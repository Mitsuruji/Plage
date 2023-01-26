package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.ParasolDTO;

public interface ParasolService {

	Parasol ajouterParasol(byte numEmplacement);
	
	Parasol enregisterParasol(Parasol parasol);
	
	Parasol enregisterParasol(ParasolDTO parasolDTO);
	
	List<Parasol> recupererParasols();
	
	Optional<Parasol> recupererParasol(Long id);
	
	Parasol recupererParasol(byte numEmplacement);
	
	List<Location> recupererLocationsByParasol(Parasol parasol);
	
	File recupererFileByParasol(Parasol parasol);
}
