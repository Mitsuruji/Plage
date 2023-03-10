package fr.orsys.projet.plage.service;

import fr.orsys.projet.plage.dto.UtilisateurDTO;

public interface UtilisateurService {

	UtilisateurDTO getUtilisateurById(Long id);

	UtilisateurDTO getUtilisateurByEmailAndMotDePasse(String email, String motDePasse, String className);
	
	void saveUtilisateur(UtilisateurDTO utilisateurDTO);
}