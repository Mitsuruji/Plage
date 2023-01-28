package fr.orsys.projet.plage.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.SubclassExhaustiveStrategy;
import org.mapstruct.SubclassMapping;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Utilisateur;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.UtilisateurDTO;

@Mapper(componentModel = "spring", subclassExhaustiveStrategy = SubclassExhaustiveStrategy.RUNTIME_EXCEPTION)
public interface UtilisateurMapper {

	UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);

	@SubclassMapping(source = Locataire.class, target = LocataireDTO.class)
	@SubclassMapping(source = Concessionnaire.class, target = ConcessionnaireDTO.class)
	UtilisateurDTO toDto(Utilisateur utilisateur);

	@SubclassMapping(source = LocataireDTO.class, target = Locataire.class)
	@SubclassMapping(source = ConcessionnaireDTO.class, target = Concessionnaire.class)
	Utilisateur toEntity(UtilisateurDTO utilisateurDTO);

}
