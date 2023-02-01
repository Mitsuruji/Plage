package fr.orsys.projet.plage.service.impl;

@Service
@AllArgsConstructor
public class FileServiceImpl implements FileService{

	private final FileDAO fileDAO;
	private final FileMapper fileMapper;
	
	@Override
	public File addFile(Byte numero, Double prixJournalier) {
		if (fileDAO.existsByNumero(numero)) {
			throw new FileExistException("Cette file est déjà présent en base");
		}
		return fileDAO.save(new File(numero, prixJournalier));
	}

	@Override
	public File saveFile(File file) {
		return fileDAO.save(file);
	}

	@Override
	public File saveFile(FileDTO fileDTO) {
		File file = fileMapper.toEntity(fileDTO, new CycleAvoidingMappingContext());
		return saveFile(file);
	}

	@Override
	public List<File> getFiles() {
		return fileDAO.findAll();
	}
	
	@Override
	public List<FileDTO> getFilesDTO() {
		return fileMapper.toDtos(fileDAO.findAll(), new CycleAvoidingMappingContext());
	}

	@Override
	public Optional<File> getFile(Long id) {
		return fileDAO.findById(id);
	}

	@Override
	public File getFile(Byte numero) {
		return fileDAO.findByNumero(numero);
	}

	@Override
	public List<Parasol> getParasolesByFile(File file) {
		return fileDAO.findParasolsById(file.getId());
	}
	
	@Override
	public File updateFile(Byte numero, Double prixJournalier) {
		if (!fileDAO.existsByNumero(numero)) {
			throw new FileNotFoundException("Cette file n'existe pas en base");
		}
		File file = getFile(numero);
		file.setPrixJournalier(prixJournalier);
		return fileDAO.save(file);
	}

}
