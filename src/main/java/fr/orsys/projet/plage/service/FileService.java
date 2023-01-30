package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.FileDTO;

public interface FileService {

	File addFile(Byte numero, Double prixJournalier);
	
	File saveFile(File file);
	
	File saveFile(FileDTO fileDTO);
	
	List<File> getFiles();
	
	List<FileDTO> getFilesDTO();
	
	Optional<File> getFile(Long id);
	
	File getFile(Byte numero);
	
	List<Parasol> getParasolesByFile(File file);
	
	File updateFile(Byte numero, Double prixJournalier); 

}
