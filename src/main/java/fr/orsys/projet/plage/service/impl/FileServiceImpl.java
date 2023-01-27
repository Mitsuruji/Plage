package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dao.FileDAO;
import fr.orsys.projet.plage.dto.FileDTO;
import fr.orsys.projet.plage.exception.FileExistantException;
import fr.orsys.projet.plage.exception.FileInexistantException;
import fr.orsys.projet.plage.mapper.FileMapper;
import fr.orsys.projet.plage.service.FileService;

@Service
public class FileServiceImpl implements FileService {

	private final FileDAO fileDAO;
	private final FileMapper fileMapper;

	public FileServiceImpl(FileDAO fileDAO, FileMapper fileMapper) {
		this.fileDAO = fileDAO;
		this.fileMapper = fileMapper;
	}

	@Override
	public File ajouterFile(byte numero, double prixJournalier) {
		if (fileDAO.existsByNumero(numero)) {
			throw new FileExistantException("Cette file est déjà présent en base");
		}
		return fileDAO.save(new File(numero, prixJournalier));
	}

	@Override
	public File enregisterFile(File file) {
		return fileDAO.save(file);
	}

	@Override
	public File enregisterFile(FileDTO fileDTO) {
		File file = fileMapper.toEntity(fileDTO);
		return enregisterFile(file);
	}

	@Override
	public List<File> recupererFiles() {
		return fileDAO.findAll();
	}

	@Override
	public Optional<File> recupererFile(Long id) {
		return fileDAO.findById(id);
	}

	@Override
	public File recupererFile(byte numero) {
		return fileDAO.findByNumero(numero);
	}

	@Override
	public List<Parasol> recupererParasolesParFile(File file) {
		return fileDAO.findParasolsById(file.getId());
	}

	@Override
	public File updateFile(byte numero, double prixJournalier) {
		if (!fileDAO.existsByNumero(numero)) {
			throw new FileInexistantException("Cette file n'existe pas en base");
		}
		File file = recupererFile(numero);
		file.setPrixJournalier(prixJournalier);
		return fileDAO.save(file);
	}

}
