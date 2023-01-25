package fr.orsys.projet.plage.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Location;

public interface LocationDAO extends JpaRepository<Location, Long> {

	Optional<Location> findById(Long id);
	List<Location> findAll();
	List<Location> findByLocataireId(Long id);
	List<Location> findByStatutId(Long id);
	
}
