package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.ParasolDTO;

@Mapper(componentModel = "spring")
public interface ParasolMapper {

	ParasolMapper INSTANCE = Mappers.getMapper( ParasolMapper.class );
	
	ParasolDTO toDto(Parasol parasol, @Context CycleAvoidingMappingContext context);	
	
	List<ParasolDTO> toDtos(List<Parasol> parasols, @Context CycleAvoidingMappingContext context);	

	Parasol toEntity(ParasolDTO parasolDTO, @Context CycleAvoidingMappingContext context);	
	
	List<Parasol> toEntities(List<ParasolDTO> parasolDTOs, @Context CycleAvoidingMappingContext context);	
}
