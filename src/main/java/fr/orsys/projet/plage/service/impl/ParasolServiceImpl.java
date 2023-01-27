package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dao.ParasolDAO;
import fr.orsys.projet.plage.dto.ParasolDTO;
import fr.orsys.projet.plage.exception.ParasolExistantException;
import fr.orsys.projet.plage.mapper.ParasolMapper;
import fr.orsys.projet.plage.service.ParasolService;

@Service
public class ParasolServiceImpl implements ParasolService {

	private final ParasolDAO parasolDAO;
	private final ParasolMapper parasolMapper;
	
	
	public ParasolServiceImpl(ParasolDAO parasolDAO, ParasolMapper parasolMapper) {
		this.parasolDAO = parasolDAO;
		this.parasolMapper = parasolMapper;
	}

	@Override
	public Parasol ajouterParasol(byte numEmplacement) {
		if (parasolDAO.existsByNumEmplacement(numEmplacement)) {
			throw new ParasolExistantException("Ce parasol est déjà présent en base");
		}
		return parasolDAO.save(new Parasol(numEmplacement));
	}

	@Override
	public Parasol enregisterParasol(Parasol parasol) {
		return parasolDAO.save(parasol);
	}

	@Override
	public Parasol enregisterParasol(ParasolDTO parasolDTO) {
		return parasolDAO.save(parasolMapper.toEntity(parasolDTO));
	}

	@Override
	public List<Parasol> recupererParasols() {
		return parasolDAO.findAll();
	}

	@Override
	public Optional<Parasol> recupererParasol(Long id) {
		return parasolDAO.findById(id);
	}

	@Override
	public Parasol recupererParasol(byte numEmplacement) {
		return parasolDAO.findByNumEmplacement(numEmplacement);
	}

	@Override
	public List<Location> recupererLocationsByParasol(Parasol parasol) {
		return parasolDAO.findLocationsByNumEmplacement(parasol.getId());
	}

	@Override
	public File recupererFileByParasol(Parasol parasol) {
		return parasolDAO.findFileById(parasol.getId());
	}

}
