package fr.orsys.projet.plage.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Statut;

public interface StatutDAO extends JpaRepository<Statut, Long> {

	Optional<Statut> findById(Long id);

	Statut findByNom(String nom);

}
