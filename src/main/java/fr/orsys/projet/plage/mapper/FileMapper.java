package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.dto.FileDTO;

@Mapper(componentModel = "spring")
public interface FileMapper {

	FileMapper INSTANCE = Mappers.getMapper( FileMapper.class );
	
	FileDTO toDto(File file);
	
	List<FileDTO> toDtos(List<File> files);

	File toEntity(FileDTO fileDTO);
	
	List<File> toEntities(List<FileDTO> fileDTOs);
}
