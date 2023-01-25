package fr.orsys.projet.plage.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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

	byte numero;
	
	double prixJournalier;
	
	@OneToMany(mappedBy="fileDTO", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	List<ParasolDTO> parasolsDTO;
	
}
