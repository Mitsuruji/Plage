package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Utilisateur;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;

public interface UtilisateurService {

	Concessionnaire ajouterConcessionnaire(String numeroDeTelephone);
	
	Concessionnaire enregisterConcessionnaire(Concessionnaire concessionnaire);
	
	Concessionnaire enregisterConcessionnaire(ConcessionnaireDTO concessionnaireDTO);
	
	List<Concessionnaire> recupererConcessionnaires();
	
	Optional<Concessionnaire> recupererConcessionnaire(Long id);
	
	Concessionnaire recupererConcessionnaire(String numeroDeTelephone);
	
	Concessionnaire updateConcessionnaire(String numeroDeTelephone);

	List<Locataire> getLocataires();

	Utilisateur getUtilisateurById(Long id);

	Utilisateur getUtilisateurByEmail(String email);

	List<Locataire> getLocatairesByPaysCode(String codePays);

	List<Locataire> getLocatairesDeParenteId(Long idLienDeParente);

	List<Locataire> getLocatairesByDateHeureInscriptionDesc(); 

	Locataire addLocataire(Locataire locataire);

	void deleteClient(Long id);
}