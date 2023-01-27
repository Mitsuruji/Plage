package fr.orsys.projet.plage.dto;

import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	
	byte numEmplacement;
	
	@ManyToMany(mappedBy="parasols")
	List<LocationDTO> locationsDTO;
	
	@ManyToOne
	FileDTO fileDTO;
}
