package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.dto.LocationDTO;

@Mapper(componentModel = "spring")
public interface LocationMapper {

	LocationMapper INSTANCE = Mappers.getMapper(LocationMapper.class);

	LocationDTO toDto(Location location);

	Location toEntity(LocationDTO locationDTO);
}
