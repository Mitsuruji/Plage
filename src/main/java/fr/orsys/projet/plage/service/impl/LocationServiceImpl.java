package fr.orsys.projet.plage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.dao.LocationDAO;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.LocationDTO;
import fr.orsys.projet.plage.enums.StatutEnum;
import fr.orsys.projet.plage.exception.LocationNotFoundException;
import fr.orsys.projet.plage.mapper.ConcessionnaireMapper;
import fr.orsys.projet.plage.mapper.CycleAvoidingMappingContext;
import fr.orsys.projet.plage.mapper.LocataireMapper;
import fr.orsys.projet.plage.mapper.LocationMapper;
import fr.orsys.projet.plage.service.LocationService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocationServiceImpl implements LocationService {

	private final LocationDAO locationDAO;
	private final LocationMapper locationMapper;
	private final LocataireMapper locataireMapper;
	private final ConcessionnaireMapper concessionnaireMapper;

	@Override
	public LocationDTO getLocation(Long id) {
	    Location location = locationDAO.findById(id)
	            .orElseThrow(() -> new LocationNotFoundException("Location d'identifiant " + id + " inexistante"));
	    return locationMapper.toDto(location, new CycleAvoidingMappingContext());
	}

	@Override
	public List<LocationDTO> getLocations() {
	    List<Location> locations = locationDAO.findAll();
	    List<LocationDTO> locationDTOs = new ArrayList<>();
	    for(Location location:locations){
	        locationDTOs.add(locationMapper.toDto(location, new CycleAvoidingMappingContext()));
	    }
	    return locationDTOs;
	}

	@Override
	public List<LocationDTO> getLocationsByConcessionnaire(ConcessionnaireDTO concessionnaireDTO){
		Concessionnaire concessionnaire = concessionnaireMapper.toEntity(concessionnaireDTO);
	    List<Location> locations = locationDAO.findByConcessionnaire(concessionnaire);
	    return locationMapper.toDtos(locations, new CycleAvoidingMappingContext());
		
	}
	
	@Override
	public List<LocationDTO> getLocationsByLocataire(LocataireDTO locataireDTO) {
	    Locataire locataire = locataireMapper.toEntity(locataireDTO);
	    List<Location> locations = locationDAO.findByLocataire(locataire);
	    return locationMapper.toDtos(locations, new CycleAvoidingMappingContext());
	}

	@Override
	public LocationDTO addLocation(LocationDTO locationDTO) {
	    Location location = locationMapper.toEntity(locationDTO, new CycleAvoidingMappingContext());
	    location = locationDAO.save(location);
	    return locationMapper.toDto(location, new CycleAvoidingMappingContext());
	}

	@Override
	public void updateLocation(LocationDTO locationDTO) {
	    Location location = locationMapper.toEntity(locationDTO, new CycleAvoidingMappingContext());
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
