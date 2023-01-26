package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;

public interface ConcessionnaireService {

	Concessionnaire ajouterConcessionnaire(String numeroDeTelephone);
	
	Concessionnaire enregisterConcessionnaire(Concessionnaire concessionnaire);
	
	Concessionnaire enregisterConcessionnaire(ConcessionnaireDTO concessionnaireDTO);
	
	List<Concessionnaire> recupererConcessionnaires();
	
	Optional<Concessionnaire> recupererConcessionnaire(Long id);
	
	Concessionnaire recupererConcessionnaire(String numeroDeTelephone);
	
	Concessionnaire updateConcessionnaire(String numeroDeTelephone);
}
