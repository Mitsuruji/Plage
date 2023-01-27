package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.dto.ParasolDTO;

@Mapper(componentModel = "spring")
public interface ParasolMapper {

	ParasolMapper INSTANCE = Mappers.getMapper( ParasolMapper.class );
	
	ParasolDTO toDto(Parasol parasol);
	
	List<ParasolDTO> toDtos(List<Parasol> parasols);

	Parasol toEntity(ParasolDTO parasolDTO);
	
	List<Parasol> toEntities(List<ParasolDTO> parasolDTOs);
}
