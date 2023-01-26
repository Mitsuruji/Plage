package fr.orsys.projet.plage.service;

import java.util.List;

import fr.orsys.projet.plage.business.Location;

public interface LocationService {
	Location getLocation(Long id);
	List<Location> getLocations();
	Location addLocation(Location location);
	void gererLocation(Long id, boolean isConfirmed);
}
