package fr.orsys.projet.plage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Parasol;

public interface FileDAO extends JpaRepository<File, Long> {

	List<Parasol> findParasolsById(Long id);

	boolean existsByNumero(byte numero);

	File findByNumero(byte numero);
}
