package fr.orsys.projet.plage.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = "**")
@AllArgsConstructor
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {

	private UtilisateurService utilisateurService;
	private JwtGeneratorService jwtGenerator;
	private AuthenticationManager authenticationManager;

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
			UtilisateurDTO userData = utilisateurService.getUtilisateurByEmailAndMotDePasse(utilisateurDTO.getEmail(),
					utilisateurDTO.getMotDePasse(), utilisateurDTO.getClass().getSimpleName());

			if (userData == null) {
				throw new UtilisateurNotFoundException("Email ou mot de passe invalides");
			}
			
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(utilisateurDTO.getEmail(), utilisateurDTO.getMotDePasse()));
			
			SecurityContextHolder.getContext().setAuthentication(authentication);

//			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

			System.out.println(jwtGenerator.generateToken(userData));
			
			return new ResponseEntity<>(jwtGenerator.generateToken(userData), HttpStatus.OK);
		} catch (UtilisateurNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

}
