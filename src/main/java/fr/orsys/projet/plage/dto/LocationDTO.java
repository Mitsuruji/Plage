package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocationDTO {

	Long id;
	LocalDateTime dateHeureDebut;
	LocalDateTime dateHeureFin;
	Double montantAReglerEnEuros;
	String remarques;
	@JsonManagedReference
	LocataireDTO locataire;
	StatutDTO statut;
	ConcessionnaireDTO concessionnaire;
	@JsonManagedReference
	List<ParasolDTO> parasols;
}
