package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.dao.PaysDAO;
import fr.orsys.projet.plage.dto.PaysDTO;
import fr.orsys.projet.plage.exception.PaysExistException;
import fr.orsys.projet.plage.mapper.PaysMapper;
import fr.orsys.projet.plage.service.PaysService;

@Service
public class PaysServiceImpl implements PaysService {

	@Autowired
	private PaysDAO paysDAO;
	private PaysMapper paysMapper;
	
	@Override
	public Pays addPays(String code, String nom) {
		if (paysDAO.existsById(code)) {
			throw new PaysExistException("Ce pays est déjà présent en base");
		}
		return paysDAO.save(new Pays(code, nom));
	}

	@Override
	public Pays savePays(Pays pays) {
		return paysDAO.save(pays);
	}

	@Override
	public Pays savePays(PaysDTO paysDTO) {
		Pays pays = paysMapper.toEntity(paysDTO);
		return savePays(pays);
	}
	
	@Override
	public List<PaysDTO> getAllPays() {
		return paysMapper.toDtos(paysDAO.findAll());
	}

	@Override
	public Optional<Pays> getPaysByCode(String code) {
		return paysDAO.findById(code);
	}
}
