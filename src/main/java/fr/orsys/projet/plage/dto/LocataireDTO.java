package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	List<LocationDTO> locations;
	PaysDTO pays;
	LienDeParenteDTO lienDeParente;

}
