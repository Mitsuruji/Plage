package fr.orsys.projet.plage.util.impl;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.util.JwtGeneratorService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.SignatureException;

@Service
public class JwtGeneratorServiceImpl implements JwtGeneratorService {

	private static final Logger logger = LoggerFactory.getLogger(JwtGeneratorServiceImpl.class);
	
	private String message = "Token genere correctement";

	private String secret = "HRlELXqpSBqsdoazjSJFHusfikdvjjseiYEBDFJSJZdfgyiomyoi";
	
	private Long jwtExpirationMs = (long) (1000 * 60 * 60 * 24);

	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
	Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

	@Override
	public Map<String, String> generateToken(UtilisateurDTO utilisateurDTO) {
		String jwtToken = "";
		Date currentDate = new Date();
		long t = currentDate.getTime();
		Date expirationTime = new Date(t + jwtExpirationMs); // 5 minutes
		jwtToken = Jwts.builder().setSubject(utilisateurDTO.getEmail()).setIssuedAt(currentDate)
				.setExpiration(expirationTime).signWith(signingKey, SignatureAlgorithm.HS256).compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put("token", jwtToken);
		jwtTokenGen.put("message", message);
		return jwtTokenGen;
	}
	
	public String getUserNameFromJwtToken(String token) {
	    return Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(token).getBody().getSubject();
	  }

	public boolean validateJwtToken(String authToken) {
	    try {
	      Jwts.parserBuilder().setSigningKey(signingKey).build().parseClaimsJws(authToken);
	      return true;
	    } catch (SignatureException e) {
	      logger.error("Invalid JWT signature: {}", e.getMessage());
	    } catch (MalformedJwtException e) {
	      logger.error("Invalid JWT token: {}", e.getMessage());
	    } catch (ExpiredJwtException e) {
	      logger.error("JWT token is expired: {}", e.getMessage());
	    } catch (UnsupportedJwtException e) {
	      logger.error("JWT token is unsupported: {}", e.getMessage());
	    } catch (IllegalArgumentException e) {
	      logger.error("JWT claims string is empty: {}", e.getMessage());
	    }

	    return false;
	}

	@Override
	public String getJwtFromLocalStorage(HttpServletRequest request) throws ServletException {
		System.out.println(request.getHeader("Authorization"));
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null && authHeader.startsWith("Bearer ")){
		     String token = authHeader.substring(7);
		     Base64.Decoder decoder = Base64.getUrlDecoder();
		     return new String(decoder.decode(token));
		} else {
			if(authHeader == null || !authHeader.startsWith("Bearer ")){
                throw new ServletException("An exception occurred");
            }  
		}
		return null;
		
		
	}
	
}
