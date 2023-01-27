package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.ParasolDTO;

public interface ParasolService {

	Parasol addParasol(byte numEmplacement);
	
	Parasol saveParasol(Parasol parasol);
	
	Parasol saveParasol(ParasolDTO parasolDTO);
	
	List<Parasol> getParasols();
	
	List<ParasolDTO> getParasolsDTO();
	
	Optional<Parasol> getParasol(Long id);
	
	Parasol getParasol(byte numEmplacement);
	
	List<Location> getLocationsByParasol(Parasol parasol);
	
	File getFileByParasol(Parasol parasol);

}
