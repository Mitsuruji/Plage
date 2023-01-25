package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.dto.PaysDTO;

@Mapper(componentModel = "spring")
public interface PaysMapper {
	
	PaysMapper INSTANCE = Mappers.getMapper( PaysMapper.class );
	
    PaysDTO toDto(Pays pays); 

    Pays toEntity(PaysDTO paysDTO);
}