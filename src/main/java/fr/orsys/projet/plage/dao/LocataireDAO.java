package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Locataire;

public interface LocataireDAO extends JpaRepository<Locataire, Long> {

	List<Locataire> findByPays(String pays);

	List<Locataire> findByOrderBydateHeureInscription(String order);

	List<Locataire> findByPaysCode(String codePays);

	List<Locataire> findByLienParenteId(Long idLienParente);

	Locataire findByEmail(String email);

}
