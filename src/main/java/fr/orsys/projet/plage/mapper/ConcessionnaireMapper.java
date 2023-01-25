package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;

@Mapper(componentModel = "spring")
public interface ConcessionnaireMapper {

	ConcessionnaireMapper INSTANCE = Mappers.getMapper( ConcessionnaireMapper.class );
	
	ConcessionnaireDTO toDto(Concessionnaire concessionnaire); 

	Concessionnaire toEntity(ConcessionnaireDTO concessionnaireDTO);
}
