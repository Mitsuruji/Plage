package fr.orsys.projet.plage.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParasolDTO {

	Long id;
	
	Byte numEmplacement;
	@JsonIgnore
	List<LocationDTO> locations;
	FileDTO file;
}
