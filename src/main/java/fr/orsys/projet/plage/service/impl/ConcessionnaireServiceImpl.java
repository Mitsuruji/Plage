package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.dao.ConcessionnaireDAO;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.exception.ConcessionnaireInexistantException;
import fr.orsys.projet.plage.exception.FileExistantException;
import fr.orsys.projet.plage.mapper.ConcessionnaireMapper;
import fr.orsys.projet.plage.service.ConcessionnaireService;

public class ConcessionnaireServiceImpl implements ConcessionnaireService{

	private ConcessionnaireDAO concessionnaireDAO;
	private ConcessionnaireMapper concessionnaireMapper;
	
	@Override
	public Concessionnaire ajouterConcessionnaire(String numeroDeTelephone) {
		if (concessionnaireDAO.existsByNumeroDeTelephone(numeroDeTelephone)) {
			throw new FileExistantException("Ce concessionnaire est déjà présent en base");
		}
		return concessionnaireDAO.save(new Concessionnaire(numeroDeTelephone));
	}

	@Override
	public Concessionnaire enregisterConcessionnaire(Concessionnaire concessionnaire) {
		return concessionnaireDAO.save(concessionnaire);
	}

	@Override
	public Concessionnaire enregisterConcessionnaire(ConcessionnaireDTO concessionnaireDTO) {
		Concessionnaire concessionnaire = concessionnaireMapper.toEntity(concessionnaireDTO);
		return enregisterConcessionnaire(concessionnaire);
	}

	@Override
	public List<Concessionnaire> recupererConcessionnaires() {
		return concessionnaireDAO.findAll();
	}

	@Override
	public Optional<Concessionnaire> recupererConcessionnaire(Long id) {
		return concessionnaireDAO.findById(id);
	}

	@Override
	public Concessionnaire recupererConcessionnaire(String numeroDeTelephone) {
		return concessionnaireDAO.findByNumeroDeTelephone(numeroDeTelephone);
	}

	@Override
	public Concessionnaire updateConcessionnaire(String numeroDeTelephone) {
		if (!concessionnaireDAO.existsByNumeroDeTelephone(numeroDeTelephone)) {
			throw new ConcessionnaireInexistantException("Ce concessionnaire n'existe pas en base");
		}
		Concessionnaire concessionnaire = recupererConcessionnaire(numeroDeTelephone);
		concessionnaire.setNumeroDeTelephone(numeroDeTelephone);
		return concessionnaireDAO.save(concessionnaire);
	}

}
