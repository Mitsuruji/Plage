package fr.orsys.projet.plage.controller.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.LocationDTO;
import fr.orsys.projet.plage.service.LocataireService;
import fr.orsys.projet.plage.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/locataire")
public class LocataireRestController {

	private LocataireService locataireService;
	private LocationService locationService;

	//feature 10
	@PostMapping("inscription")
	@ResponseStatus(HttpStatus.CREATED)
	public LocataireDTO inscription(@RequestBody LocataireDTO locataireDTO) {
		return locataireService.addLocataire(locataireDTO);
	}

	//feature 11
	@GetMapping("reservations")
	public List<LocationDTO> getReservations(@RequestBody LocataireDTO locataireDTO) {
		return locationService.getLocationsByLocataire(locataireDTO);
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
