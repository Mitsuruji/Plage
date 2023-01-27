package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Statut;
import fr.orsys.projet.plage.dto.StatutDTO;

@Mapper(componentModel = "spring")
public interface StatutMapper {
	
	StatutMapper INSTANCE = Mappers.getMapper( StatutMapper.class );
	
	StatutDTO toDto(Statut statut); 

    Statut toEntity(StatutDTO statutDTO);
}