package util.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;

import fr.orsys.projet.plage.business.Utilisateur;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import util.JwtGenerator;

public class JwtGeneratorImpl implements JwtGenerator{

	  @Value("${app.jwttoken.message}")
	  private String message;
	  
	  SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	  
	  @Override
	  public Map<String, String> generateToken(Utilisateur utilisateur) {
	    String jwtToken="";
	    jwtToken = Jwts.builder().setSubject(utilisateur.getEmail()).setIssuedAt(new Date()).signWith(key, SignatureAlgorithm.HS256).compact();
	    Map<String, String> jwtTokenGen = new HashMap<>();
	    jwtTokenGen.put("token", jwtToken);
	    jwtTokenGen.put("message", message);
	    return jwtTokenGen;
	  }

}
