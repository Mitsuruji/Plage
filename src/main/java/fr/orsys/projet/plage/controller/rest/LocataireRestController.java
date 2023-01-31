package fr.orsys.projet.plage.controller.rest;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.LocationDTO;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import fr.orsys.projet.plage.service.LocataireService;
import fr.orsys.projet.plage.service.LocationService;
import fr.orsys.projet.plage.util.JwtGeneratorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = "**")
@AllArgsConstructor
@RequestMapping("/api/locataire")
public class LocataireRestController {

	private LocataireService locataireService;
	private LocationService locationService;
	private JwtGeneratorService jwtGeneratorService;
	
	

	//feature 10
	@PostMapping("inscription")
	@ResponseStatus(HttpStatus.CREATED)
	public LocataireDTO inscription(@RequestBody LocataireDTO locataireDTO) {
		return locataireService.addLocataire(locataireDTO);
	}

	//feature 11
	@GetMapping("locations")
	public ResponseEntity<Object> getReservations(HttpServletRequest request){
		
		try {
			String jwt = jwtGeneratorService.getJwtFromLocalStorage(request);
			String email = jwtGeneratorService.getEmailFromJwtToken(jwt);
			
			LocataireDTO locataireDTO = locataireService.getLocataireByEmail(email);
			List<LocationDTO> locations = locationService.getLocationsByLocataire(locataireDTO);
			
			ObjectMapper mapper = new ObjectMapper();
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	        mapper.registerModule(new JavaTimeModule());
			
			String jsonStr = mapper.writeValueAsString(locations);
			System.out.println(jsonStr);
			return new ResponseEntity<>(jsonStr, HttpStatus.OK);
			
		} catch (UtilisateurNotFoundException | ServletException | JsonProcessingException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		
	}

	//feature 12
	@PostMapping("ajout-reservation")
	@ResponseStatus(HttpStatus.CREATED)
	@Operation(description = "Ajoute une réservation en base")
	public LocationDTO ajouterReservation(@RequestBody LocationDTO locationDTO) {
		return locationService.addLocation(locationDTO);
	}

	//feature 13
	@DeleteMapping("suppression-locataire/{id}")
	public void suppressionLocataire(@PathVariable Long id) {
		locataireService.deleteLocataire(id);
	}

}
