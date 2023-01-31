package fr.orsys.projet.plage.service;

import java.util.List;

import fr.orsys.projet.plage.dto.LocataireDTO;

public interface LocataireService {

	List<LocataireDTO> getLocataires();
	
	LocataireDTO getLocataireByEmail(String email);
	
	List<LocataireDTO> getLocatairesByPaysCode(String codePays);

	List<LocataireDTO> getLocatairesDeParenteId(Long idLienDeParente);

	List<LocataireDTO> getLocatairesByDateHeureInscriptionDesc(); 

	LocataireDTO addLocataire(LocataireDTO locataireDTO);

	void deleteLocataire(Long id);
}