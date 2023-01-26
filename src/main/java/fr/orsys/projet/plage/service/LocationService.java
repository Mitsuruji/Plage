package fr.orsys.projet.plage.service;

import java.util.List;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Location;

public interface LocationService {
	Location getLocation(Long id);
	List<Location> getLocations();
	List<Location> getLocationsByLocataire(Locataire locataire);
	Location addLocation(Location location);
     void updateLocation(Location location);
    void deleteLocation(long id);
	void gererLocation(Long id, boolean isConfirmed);
}
