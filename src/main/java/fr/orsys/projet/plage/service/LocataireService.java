package fr.orsys.projet.plage.service;

import java.util.List;

import fr.orsys.projet.plage.business.Locataire;

public interface LocataireService {

	List<Locataire> getLocataires();

	Locataire getLocataireById(Long id);

	Locataire getLocataireByEmail(String email);

	List<Locataire> getLocatairesByPays(String codePays);

	List<Locataire> getLocatairesByLienParente(Long idLienParente);

	List<Locataire> getLocatairesBySateHeureInscription(String order);

	Locataire addLocataire(Locataire locataire);

	void deleteClient(Long id);
}
