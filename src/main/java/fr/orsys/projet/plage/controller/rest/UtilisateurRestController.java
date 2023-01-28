package fr.orsys.projet.plage.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import fr.orsys.projet.plage.service.UtilisateurService;
import fr.orsys.projet.plage.util.JwtGeneratorService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {

	private UtilisateurService utilisateurService;
	private JwtGeneratorService jwtGenerator;

	@PostMapping("/inscription")
	public ResponseEntity<Object> postUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
		try {
			utilisateurService.saveUtilisateur(utilisateurDTO);
			return new ResponseEntity<>(utilisateurDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/authentification")
	public ResponseEntity<Object> loginUtilisateur(@RequestBody UtilisateurDTO utilisateurDTO) {
		try {
			if (utilisateurDTO.getEmail() == null || utilisateurDTO.getMotDePasse() == null) {
				throw new UtilisateurNotFoundException("Email ou mot de passe vide");
			}
			UtilisateurDTO userData = utilisateurService.getUtilisateurByEmailAndMotDePasse(utilisateurDTO.getEmail(), utilisateurDTO.getMotDePasse());
			if (userData == null) {
				throw new UtilisateurNotFoundException("Email ou mot de passe invalides");
			}
			return new ResponseEntity<>(jwtGenerator.generateToken(utilisateurDTO), HttpStatus.OK);
		} catch (UtilisateurNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
