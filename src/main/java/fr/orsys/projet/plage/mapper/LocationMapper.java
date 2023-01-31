package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.dto.LocationDTO;

@Mapper(componentModel = "spring")
public interface LocationMapper {

	LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

	LocationDTO toDto(Location location, @Context CycleAvoidingMappingContext context);	

	List<LocationDTO> toDtos(List<Location> locations, @Context CycleAvoidingMappingContext context);

	Location toEntity(LocationDTO locationDTO, @Context CycleAvoidingMappingContext context);

	List<Location> toEntities(List<LocationDTO> locationDTOs, @Context CycleAvoidingMappingContext context);
}
