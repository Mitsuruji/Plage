package fr.orsys.projet.plage.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Locataire;

public interface LocataireDAO extends JpaRepository<Locataire, Long> {

	Optional<Locataire> findById(Long id);
	List<Locataire> findAll();
	
}
