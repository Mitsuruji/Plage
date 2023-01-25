package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.dto.LocataireDTO;

@Mapper(componentModel = "spring")
public interface LocataireMapper {

    LocataireMapper INSTANCE = Mappers.getMapper(LocataireMapper.class);

    LocataireDTO toDto(Locataire locataire);

    Locataire toEntity(LocataireDTO locataireDTO);
}