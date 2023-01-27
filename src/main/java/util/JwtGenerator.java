package util;

import java.util.Map;

import fr.orsys.projet.plage.business.Utilisateur;

public interface JwtGenerator {

	Map<String, String> generateToken(Utilisateur utilisateur);
	
}
