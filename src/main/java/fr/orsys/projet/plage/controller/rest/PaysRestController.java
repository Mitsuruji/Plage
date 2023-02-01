package fr.orsys.projet.plage.controller.rest;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.projet.plage.dto.PaysDTO;
import fr.orsys.projet.plage.exception.PaysNotFoundException;
import fr.orsys.projet.plage.service.PaysService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = "**")
@AllArgsConstructor
@RequestMapping("/api/pays")
public class PaysRestController {

	private PaysService paysService;

	@GetMapping("")
	public ResponseEntity<Object> getAllPays(HttpServletRequest request) {
		try {
			List<PaysDTO> listPaysDTO = paysService.getAllPays();
			return ResponseEntity.ok(listPaysDTO);
		} catch (PaysNotFoundException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
}
