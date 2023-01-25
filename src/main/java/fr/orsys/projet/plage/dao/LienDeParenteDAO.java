package fr.orsys.projet.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.LienDeParente;

public interface LienDeParenteDAO extends JpaRepository<LienDeParente, Long>{
	
	float findCoefficientByNom (String nom);

}
