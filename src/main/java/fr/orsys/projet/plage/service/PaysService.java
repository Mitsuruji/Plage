package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.dto.PaysDTO;

public interface PaysService {

	Pays addPays(String nom, String code);
	
	Pays savePays(Pays pays);
	
	Pays savePays(PaysDTO paysDTO);
	
	List<PaysDTO> getAllPays();
	
	Optional<Pays> getPaysByCode(String code);
	
}
