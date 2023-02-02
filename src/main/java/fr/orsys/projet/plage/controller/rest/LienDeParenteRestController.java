package fr.orsys.projet.plage.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.projet.plage.dto.LienDeParenteDTO;
import fr.orsys.projet.plage.exception.FileNotFoundException;
import fr.orsys.projet.plage.service.LienDeParenteService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = "**")
@AllArgsConstructor
@RequestMapping("/api/lien-de-parente")
public class LienDeParenteRestController {

	private LienDeParenteService lienDeParenteService;

	@GetMapping("")
	public ResponseEntity<Object> getLiens(HttpServletRequest request) {
		try {
			List<LienDeParenteDTO> listLienDTO = lienDeParenteService.getLienDeParentes();
			return ResponseEntity.ok(listLienDTO);
		} catch (FileNotFoundException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
