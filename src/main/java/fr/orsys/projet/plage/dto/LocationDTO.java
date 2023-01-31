package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
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
public class LocationDTO {

	Long id;
	LocalDateTime dateHeureDebut;
	LocalDateTime dateHeureFin;
	Double montantAReglerEnEuros;
	String remarques;
	LocataireDTO locataire;
	StatutDTO statut;
	ConcessionnaireDTO concessionnaire;
	List<ParasolDTO> parasols;
}
