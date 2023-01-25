package fr.orsys.projet.plage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.Concessionnaire;

public interface ConcessionnaireDAO extends JpaRepository<Concessionnaire, String>{

}
