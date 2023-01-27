package fr.orsys.projet.plage.controller.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.ParasolDTO;
import fr.orsys.projet.plage.service.ParasolService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/")
public class ParasolRestController {

private ParasolService parasolService;
	
	@GetMapping("parasols")
	public List<ParasolDTO> getParasols() {
		return parasolService.getParasolsDTO();
	}
	
	@PostMapping("parasols/{numEmplacement}")
	@ResponseStatus(code=HttpStatus.CREATED)
	public Parasol postParasol(byte numEmplacement) {
		return parasolService.addParasol(numEmplacement);
	}
	
	@ExceptionHandler(fr.orsys.projet.plage.exception.ParasolExistException.class)
	@ResponseStatus(code=HttpStatus.CONFLICT)
	public String processParasolExist(Exception exception) {
		return exception.getMessage();
	}
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
    @ResponseStatus(code=HttpStatus.UNPROCESSABLE_ENTITY)
    public List<String> processInvalidData(ConstraintViolationException exception) {
        return exception.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
    }
}
