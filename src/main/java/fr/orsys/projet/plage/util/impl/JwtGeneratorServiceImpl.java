package fr.orsys.projet.plage.util.impl;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.util.JwtGeneratorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtGeneratorServiceImpl implements JwtGeneratorService {

	private String message = "Token genere correctement";

	private String secret = "HRlELXqpSBqsdoazjSJFHusfikdvjjseiYEBDFJSJZdfgyiomyoi";

	byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret);
	Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

	@Override
	public Map<String, String> generateToken(UtilisateurDTO utilisateurDTO) {
		String jwtToken = "";
		Date currentDate = new Date();
		long t = currentDate.getTime();
		Date expirationTime = new Date(t + 3000000); // 5 minutes
		jwtToken = Jwts.builder().setSubject(utilisateurDTO.getEmail()).setIssuedAt(currentDate)
				.setExpiration(expirationTime).signWith(signingKey, SignatureAlgorithm.HS256).compact();
		Map<String, String> jwtTokenGen = new HashMap<>();
		jwtTokenGen.put("token", jwtToken);
		jwtTokenGen.put("message", message);
		return jwtTokenGen;
	}
	
//	@Override
//	public Map<String, String> generateToken(UtilisateurDTO utilisateurDTO) {
//	    String jwtToken = "";
//	    Date currentDate = new Date();
//	    Date expirationTime = new Date(currentDate.getTime() + (30 * 60 * 1000));
//	    byte[] apiKeySecretBytes = new byte[32];
//	    secureRandom.nextBytes(apiKeySecretBytes);
//	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());
//
//	    jwtToken = Jwts.builder().setSubject(utilisateurDTO.getEmail()).setIssuedAt(currentDate)
//	            .setExpiration(expirationTime).signWith(signingKey, SignatureAlgorithm.HS256).compact();
//	    Map<String, String> jwtTokenGen = new HashMap<>();
//	    jwtTokenGen.put("token", jwtToken);
//	    jwtTokenGen.put("message", message);
//	    return jwtTokenGen;
//	}

}
