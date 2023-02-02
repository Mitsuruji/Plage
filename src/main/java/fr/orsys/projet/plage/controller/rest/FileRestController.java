package fr.orsys.projet.plage.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.dto.FileDTO;
import fr.orsys.projet.plage.exception.FileNotFoundException;
import fr.orsys.projet.plage.service.FileService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = "**")
@AllArgsConstructor
@RequestMapping("/api/file")
public class FileRestController {

	private FileService fileService;

	@GetMapping("")
	public ResponseEntity<Object> getFiles(HttpServletRequest request) {
		try {
			List<FileDTO> FileDTOs = fileService.getFilesDTO();
			return ResponseEntity.ok(FileDTOs);
		} catch (FileNotFoundException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

	@PostMapping("{numero}/{prixJournalier}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public File postFile(byte numero, double prixJournalier) {
		return fileService.addFile(numero, prixJournalier);
	}

	@PatchMapping("{numero}/{newPrixJournalier}")
	public File patchJour(@PathVariable byte numero, @PathVariable double newPrixJournalier) {
		return fileService.updateFile(numero, newPrixJournalier);
	}

	@ExceptionHandler(fr.orsys.projet.plage.exception.FileExistException.class)
	@ResponseStatus(code = HttpStatus.CONFLICT)
	public String processFileExist(Exception exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(fr.orsys.projet.plage.exception.FileNotFoundException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public String processFileMissing(Exception exception) {
		return exception.getMessage();
	}

	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public List<String> processInvalidData(ConstraintViolationException exception) {
		return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList();
	}
}
