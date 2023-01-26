package fr.orsys.projet.plage.service;

import java.util.List;

import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.LocationDTO;

public interface LocationService {
	LocationDTO getLocation(Long id);

	List<LocationDTO> getLocations();

	List<LocationDTO> getLocationsByLocataire(LocataireDTO locataireDTO);

	LocationDTO addLocation(LocationDTO locationDTO);

	void updateLocation(LocationDTO locationDTO);

	void deleteLocation(long id);

	void gererLocation(Long id, boolean isConfirmed);

}
