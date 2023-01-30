package fr.orsys.projet.plage.dto;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileDTO {

	Long id;
	
	Byte numero;
	
	Double prixJournalier;
	
	List<ParasolDTO> parasols;
	
}
