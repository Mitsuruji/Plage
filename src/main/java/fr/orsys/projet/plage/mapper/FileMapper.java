package fr.orsys.projet.plage.mapper;

import java.util.List;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.dto.FileDTO;

@Mapper(componentModel = "spring")
public interface FileMapper {

	FileMapper INSTANCE = Mappers.getMapper( FileMapper.class );
	
	FileDTO toDto(File file, @Context CycleAvoidingMappingContext context);	
	
	List<FileDTO> toDtos(List<File> files, @Context CycleAvoidingMappingContext context);	

	File toEntity(FileDTO fileDTO, @Context CycleAvoidingMappingContext context);	
	
	List<File> toEntities(List<FileDTO> fileDTOs, @Context CycleAvoidingMappingContext context);	
}
