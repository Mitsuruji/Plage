package fr.orsys.projet.plage.service;

import java.util.List;

import fr.orsys.projet.plage.business.Locataire;

public interface LocataireService {

	List<Locataire> getLocataires();

	Locataire getLocataireById(Long id);

	Locataire getLocataireByEmail(String email);

	List<Locataire> getLocatairesByPaysCode(String codePays);

	List<Locataire> getLocatairesDeParenteId(Long idLienDeParente);

	List<Locataire> getLocatairesByDateHeureInscriptionDesc(); 

	Locataire addLocataire(Locataire locataire);

	void deleteClient(Long id);
}
