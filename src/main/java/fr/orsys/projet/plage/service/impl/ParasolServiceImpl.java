package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dao.ParasolDAO;
import fr.orsys.projet.plage.dto.ParasolDTO;
import fr.orsys.projet.plage.exception.ParasolExistException;
import fr.orsys.projet.plage.mapper.CycleAvoidingMappingContext;
import fr.orsys.projet.plage.mapper.ParasolMapper;
import fr.orsys.projet.plage.service.ParasolService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ParasolServiceImpl implements ParasolService {

	private ParasolDAO parasolDAO;
	private ParasolMapper parasolMapper;
		
	@Override
	public Parasol addParasol(byte numEmplacement) {
		if (parasolDAO.existsByNumEmplacement(numEmplacement)) {
			throw new ParasolExistException("Ce parasol est déjà présent en base");
		}
		return parasolDAO.save(new Parasol(numEmplacement));
	}

	@Override
	public Parasol saveParasol(Parasol parasol) {
		return parasolDAO.save(parasol);
	}

	@Override
	public Parasol saveParasol(ParasolDTO parasolDTO) {
		Parasol parasol = parasolMapper.toEntity(parasolDTO, new CycleAvoidingMappingContext());
		return parasolDAO.save(parasol);
	}

	@Override
	public List<Parasol> getParasols() {
		return parasolDAO.findAll();
	}
	
	@Override
	public List<ParasolDTO> getParasolsDTO() {
		return parasolMapper.toDtos(parasolDAO.findAll(), new CycleAvoidingMappingContext());
	}

	@Override
	public Optional<Parasol> getParasol(Long id) {
		return parasolDAO.findById(id);
	}

	@Override
	public Parasol getParasol(byte numEmplacement) {
		return parasolDAO.findByNumEmplacement(numEmplacement);
	}

	@Override
	public List<Location> getLocationsByParasol(Parasol parasol) {
		return parasolDAO.findLocationsByNumEmplacement(parasol.getId());
	}

	@Override
	public File getFileByParasol(Parasol parasol) {
		return parasolDAO.findFileById(parasol.getId());
	}

}
