package fr.orsys.projet.plage.util.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.util.JwtGeneratorService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtGeneratorServiceImpl implements JwtGeneratorService{

	  @Value("${app.jwttoken.message}")
	  private String message;
	  
	  SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	  
	  @Override
	  public Map<String, String> generateToken(UtilisateurDTO utilisateurDTO) {
	    String jwtToken="";
        Date currentDate = new Date();
        long t = currentDate.getTime();
        Date expirationTime = new Date(t + 3000000); // 5 minutes
	    jwtToken = Jwts.builder().setSubject(utilisateurDTO.getEmail()).setIssuedAt(currentDate).setExpiration(expirationTime).signWith(key, SignatureAlgorithm.HS256).compact();
	    Map<String, String> jwtTokenGen = new HashMap<>();
	    jwtTokenGen.put("token", jwtToken);
	    jwtTokenGen.put("message", message);
	    return jwtTokenGen;
	  }

}
