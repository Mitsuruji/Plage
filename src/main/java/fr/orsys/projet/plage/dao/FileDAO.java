package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Parasol;

public interface FileDAO extends JpaRepository<File, Long> {

	List<Parasol> findByNumero(byte numero);
	
	@Query(value="select f from Files f where f.prix_journalier <= :prix_max AND f.prix_journalier >= :prix_min", nativeQuery = true)
	List<File> findAllByPrixMinAndMax(@Param("prix_min") double prixMin, @Param("prix_max") double prixMax);
}
