package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Locataire;

public interface LocataireDAO extends JpaRepository<Locataire, Long> {

	List<Locataire> findByPays(String pays);

	List<Locataire> findAllByOrderByDateHeureInscriptionDesc();

	List<Locataire> findByPaysCode(String codePays);

	List<Locataire> findByLienDeParenteId(Long idLienParente);

	Locataire findByEmail(String email);

}

