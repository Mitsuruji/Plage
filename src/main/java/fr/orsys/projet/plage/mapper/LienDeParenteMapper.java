package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.dto.LienDeParenteDTO;

@Mapper(componentModel = "spring")
public interface LienDeParenteMapper {

	LienDeParenteMapper INSTANCE = Mappers.getMapper( LienDeParenteMapper.class );
	
	LienDeParenteDTO toDto(LienDeParente lienDeParente); 
	
	List<LienDeParenteDTO> toDtos(List<LienDeParente> lienDeParentes); 

	LienDeParente toEntity(LienDeParenteDTO lienDeParenteDTO);
}
