package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.ParasolDTO;

@Mapper(componentModel = "spring")
public interface ParasolMapper {

	ParasolMapper INSTANCE = Mappers.getMapper( ParasolMapper.class );
	
	ParasolDTO toDto(Parasol parasol); 

	Parasol toEntity(ParasolDTO parasolDTO);
}
