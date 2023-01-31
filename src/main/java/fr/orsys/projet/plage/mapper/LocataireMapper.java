package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.dto.LocataireDTO;

@Mapper(componentModel = "spring")
public interface LocataireMapper {

	LocataireMapper INSTANCE = Mappers.getMapper(LocataireMapper.class);

	LocataireDTO toDto(Locataire locataire, @Context CycleAvoidingMappingContext context);

	Locataire toEntity(LocataireDTO locataireDTO, @Context CycleAvoidingMappingContext context);

	List<LocataireDTO> toDtos(List<Locataire> locataires, @Context CycleAvoidingMappingContext context);
}
