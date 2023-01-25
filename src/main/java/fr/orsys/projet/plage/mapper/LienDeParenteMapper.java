package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.dto.LienDeParenteDTO;

@Mapper(componentModel = "spring")
public interface LienDeParenteMapper {

	LienDeParenteMapper INSTANCE = Mappers.getMapper( LienDeParenteMapper.class );
	
	LienDeParenteDTO toDto(LienDeParente LienDeParente); 

	LienDeParente toEntity(LienDeParenteDTO lienDeParenteDTO);
}
