package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.dao.PaysDAO;
import fr.orsys.projet.plage.dto.PaysDTO;
import fr.orsys.projet.plage.exception.PaysExistantException;
import fr.orsys.projet.plage.mapper.PaysMapper;
import fr.orsys.projet.plage.service.PaysService;

@Service
public class PaysServiceImpl implements PaysService {

	private final PaysDAO paysDAO;
	private final PaysMapper paysMapper;	
	
	public PaysServiceImpl(PaysDAO paysDAO, PaysMapper paysMapper) {
		this.paysDAO = paysDAO;
		this.paysMapper = paysMapper;
	}

	@Override
	public Pays ajouterPays(String code, String nom) {
		if (paysDAO.existsById(code)) {
			throw new PaysExistantException("Ce pays est déjà présent en base");
		}
		return paysDAO.save(new Pays(code, nom));
	}

	@Override
	public Pays enregistrerPays(Pays pays) {
		return paysDAO.save(pays);
	}

	@Override
	public Pays enregistrerPays(PaysDTO paysDTO) {
		Pays pays = paysMapper.toEntity(paysDTO);
		return enregistrerPays(pays);
	}
	
	@Override
	public List<Pays> recupererTousPays() {
		return paysDAO.findAll();
	}

	@Override
	public Optional<Pays> recupererPaysByCode(String code) {
		return paysDAO.findById(code);
	}

	@Override
	public Pays recupererPaysByNom(String nom) {
		return paysDAO.findByNom(nom);
	}

}
