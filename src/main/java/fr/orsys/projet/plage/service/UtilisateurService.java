package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.UtilisateurDTO;

public interface UtilisateurService {

	Concessionnaire addConcessionnaire(String numeroDeTelephone);
	
	Concessionnaire saveConcessionnaire(Concessionnaire concessionnaire);
	
	Concessionnaire saveConcessionnaire(ConcessionnaireDTO concessionnaireDTO);
	
	List<Concessionnaire> getConcessionnaires();
	
	Optional<Concessionnaire> getConcessionnaire(Long id);
	
	Concessionnaire getConcessionnaire(String numeroDeTelephone);
	
	Concessionnaire updateConcessionnaire(String numeroDeTelephone);

	List<LocataireDTO> getLocataires();

	UtilisateurDTO getUtilisateurById(Long id);

	UtilisateurDTO getUtilisateurByEmail(String email);

	List<LocataireDTO> getLocatairesByPaysCode(String codePays);

	List<LocataireDTO> getLocatairesDeParenteId(Long idLienDeParente);

	List<LocataireDTO> getLocatairesByDateHeureInscriptionDesc(); 

	LocataireDTO addLocataire(LocataireDTO locataireDTO);

	void deleteClient(Long id);
}