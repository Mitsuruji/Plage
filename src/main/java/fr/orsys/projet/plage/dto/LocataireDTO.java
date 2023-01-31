package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LocataireDTO  extends UtilisateurDTO{

	LocalDateTime dateHeureInscription;
	@JsonBackReference
	List<LocationDTO> locations;
	@JsonManagedReference
	PaysDTO pays;
	LienDeParenteDTO lienDeParente;

}
