package fr.orsys.projet.plage.util;

import java.util.Map;

import fr.orsys.projet.plage.dto.UtilisateurDTO;

public interface JwtGeneratorService {

	Map<String, String> generateToken(UtilisateurDTO utilisateurDTO);
	
}
