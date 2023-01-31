package fr.orsys.projet.plage.util;

import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import fr.orsys.projet.plage.dto.UtilisateurDTO;

public interface JwtGeneratorService {

	Map<String, String> generateToken(UtilisateurDTO utilisateurDTO);
	
	String getEmailFromJwtToken(String token);
	
	boolean validateJwtToken(String authToken);

	String getJwtFromLocalStorage(HttpServletRequest request) throws ServletException;
	
}
