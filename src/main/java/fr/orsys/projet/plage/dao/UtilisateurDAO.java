package fr.orsys.projet.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByEmail(String email);

}
