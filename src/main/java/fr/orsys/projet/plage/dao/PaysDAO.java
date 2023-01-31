package fr.orsys.projet.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Pays;

public interface PaysDAO extends JpaRepository<Pays, String> {

	Pays findByCode(String code);

}
