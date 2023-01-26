package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.FileDTO;

public interface FileService {

	File ajouterFile(byte numero, double prixJournalier);
	
	File enregisterFile(File file);
	
	File enregisterFile(FileDTO fileDTO);
	
	List<File> recupererFiles();
	
	Optional<File> recupererFile(Long id);
	
	File recupererFile(byte numero);
	
	List<Parasol> recupererParasolesParFile(File file);
	
	File updateFile(byte numero, double prixJournalier);
}
