package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Location;

public interface LocationDAO extends JpaRepository<Location, Long> {

	List<Location> findByLocataireId(Long id);
	List<Location> findByStatutId(Long id);
	List<Location> findByLocataire(Locataire locataire);
	List<Location> findByConcessionnaire(Concessionnaire concessionnaire);
	
}
