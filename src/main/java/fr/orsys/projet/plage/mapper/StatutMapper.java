package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Statut;
import fr.orsys.projet.plage.dto.StatutDTO;

@Mapper(componentModel = "spring")
public interface StatutMapper {
	
	PaysMapper INSTANCE = Mappers.getMapper( PaysMapper.class );
	
	StatutDTO toDto(Statut statut); 

    Statut toEntity(StatutDTO statutDTO);
}