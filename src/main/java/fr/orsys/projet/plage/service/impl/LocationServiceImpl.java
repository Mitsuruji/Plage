package fr.orsys.projet.plage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.dao.LocationDAO;
import fr.orsys.projet.plage.enums.StatutEnum;
import fr.orsys.projet.plage.exception.LocationNotFoundException;
import fr.orsys.projet.plage.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	private final LocationDAO locationDAO;

	public LocationServiceImpl(LocationDAO locationDAO) {
		this.locationDAO = locationDAO;
	}

	@Override
	public Location getLocation(Long id) {
		return locationDAO.findById(id)
				.orElseThrow(() -> new LocationNotFoundException("Location d'identifiant " + id + " inexistante"));
	}

	@Override
	public List<Location> getLocations() {
		return locationDAO.findAll();
	}

	@Override
	public List<Location> getLocationsByLocataire(Locataire locataire) {
		return locationDAO.findByLocataire(locataire);
	}

	@Override
	public Location addLocation(Location location) {
		return locationDAO.save(location);
	}

	@Override
	public void updateLocation(Location location) {
		locationDAO.save(location);
	}

	@Override
	public void deleteLocation(long id) {
		locationDAO.deleteById(id);
	}

	@Override
	public void gererLocation(Long id, boolean isConfirmed) {
		Location location = locationDAO.findById(id)
				.orElseThrow(() -> new LocationNotFoundException("Location d'identifiant " + id + " inexistante"));
		if (isConfirmed) {
			location.getStatut().setNom(StatutEnum.CONFIRMEE.toString());
		} else {
			location.getStatut().setNom(StatutEnum.REFUSEE.toString());
		}
		locationDAO.save(location);
	}

}
