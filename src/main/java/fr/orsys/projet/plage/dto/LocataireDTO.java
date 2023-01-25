package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
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
public class LocataireDTO  extends UtilisateurDTO{

	LocalDateTime dateHeureInscription;
	LienDeParenteDTO lienDeParente;
	List<LocationDTO> locations;
	PaysDTO pays;

}
