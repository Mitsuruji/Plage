package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;

public interface ParasolDAO extends JpaRepository<Parasol, Long> {

	List<Location> findLocationsByNumEmplacement(Long id);
	
	Parasol findByNumEmplacement(byte numEmplacement);
	
	File findFileById(Long id);

	boolean existsByNumEmplacement(byte numEmplacement);
}
