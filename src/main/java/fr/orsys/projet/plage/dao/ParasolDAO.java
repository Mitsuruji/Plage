package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;

public interface ParasolDAO extends JpaRepository<Parasol, Long> {

	List<Location> findByNumEmplacement(byte numEmpl);
	
	Parasol findByNumEmplacementAndFileId(byte numEmplacement, Long fileId);
	
	File findFileById(Long id);
}
