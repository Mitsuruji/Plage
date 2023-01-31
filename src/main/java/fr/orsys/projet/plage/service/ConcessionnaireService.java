package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;

public interface ConcessionnaireService {

	Concessionnaire addConcessionnaire(String numeroDeTelephone);

	Concessionnaire saveConcessionnaire(Concessionnaire concessionnaire);

	Concessionnaire saveConcessionnaire(ConcessionnaireDTO concessionnaireDTO);

	List<Concessionnaire> getConcessionnaires();

	Optional<Concessionnaire> getConcessionnaire(Long id);

	Concessionnaire getConcessionnaireByTel(String numeroDeTelephone);
	
	Concessionnaire getConcessionnaireByEmail(String email);

	Concessionnaire updateConcessionnaire(String numeroDeTelephone);
}