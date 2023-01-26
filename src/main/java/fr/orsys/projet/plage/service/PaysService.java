package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.dto.PaysDTO;

public interface PaysService {

	Pays ajouterPays(String nom, String code);
	
	Pays enregistrerPays(Pays pays);
	
	Pays enregistrerPays(PaysDTO paysDTO);
	
	List<Pays> recupererTousPays();
	
	Optional<Pays> recupererPaysByCode(String code);
	
	Pays recupererPaysByNom(String nom);
	
}
