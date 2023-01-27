package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Utilisateur;
import fr.orsys.projet.plage.dto.UtilisateurDTO;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

	UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

	UtilisateurDTO toDto(Utilisateur utilisateur);
}
