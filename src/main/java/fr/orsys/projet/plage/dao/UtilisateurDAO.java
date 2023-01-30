package fr.orsys.projet.plage.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByEmailAndMotDePasse(String email, String motDePasse);

	Optional<Utilisateur> findByEmail(String email);

}
