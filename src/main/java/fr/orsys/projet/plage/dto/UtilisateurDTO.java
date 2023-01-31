package fr.orsys.projet.plage.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PROTECTED)
@JsonSubTypes({ @JsonSubTypes.Type(value = LocataireDTO.class, name = "Locataire"),
		@JsonSubTypes.Type(value = ConcessionnaireDTO.class, name = "Concessionnaire") })
public abstract class UtilisateurDTO {
	Long id;
	String nom;
	String prenom;
	String email;
	String motDePasse;
}
