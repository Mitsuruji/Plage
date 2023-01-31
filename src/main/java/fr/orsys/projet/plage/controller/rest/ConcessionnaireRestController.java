package fr.orsys.projet.plage.controller.rest;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.dto.LocationDTO;
import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import fr.orsys.projet.plage.mapper.ConcessionnaireMapper;
import fr.orsys.projet.plage.service.ConcessionnaireService;
import fr.orsys.projet.plage.service.LocationService;
import fr.orsys.projet.plage.util.JwtGeneratorService;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600, exposedHeaders = "**")
@AllArgsConstructor
@RequestMapping("/api/concessionnaire")
public class ConcessionnaireRestController {

	private ConcessionnaireService concessionnaireService;
	private JwtGeneratorService jwtGeneratorService;
	private ConcessionnaireMapper concessionnaireMapper;
	private LocationService locationService;
	
	@GetMapping("locations")
	public ResponseEntity<Object> getLocations(HttpServletRequest request){
		
		try {
			String jws = jwtGeneratorService.getJwtFromLocalStorage(request);
			String email = jwtGeneratorService.getEmailFromJwtToken(jws);
			
			ConcessionnaireDTO concessionnaireDTO = concessionnaireMapper.toDto(concessionnaireService.getConcessionnaireByEmail(email));
			List<LocationDTO> locations = locationService.getLocationsByConcessionnaire(concessionnaireDTO);
			
			ObjectMapper mapper = new ObjectMapper();
	        mapper.enable(SerializationFeature.INDENT_OUTPUT);
	        mapper.registerModule(new JavaTimeModule());
			
			String jsonStr = mapper.writeValueAsString(locations);
			return new ResponseEntity<>(jsonStr, HttpStatus.OK);
			
		} catch (UtilisateurNotFoundException | ServletException | JsonProcessingException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
		}
		
	}
}
