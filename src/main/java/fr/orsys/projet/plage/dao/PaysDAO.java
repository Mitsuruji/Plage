package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Pays;

public interface PaysDAO extends JpaRepository<Pays, String> {
	
	List<Locataire> findByNom(String nom);

}
