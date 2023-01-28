package fr.orsys.projet.plage.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonTypeInfo(
	      use = JsonTypeInfo.Id.NAME, 
	      include = JsonTypeInfo.As.PROPERTY, 
	      property = "type",
	      visible = true)
	    @JsonSubTypes({
	        @JsonSubTypes.Type(value = Concessionnaire.class, name = "concessionnaire"),
	        @JsonSubTypes.Type(value = Locataire.class, name = "locataire")
	    })
public abstract class UtilisateurDTO {

	String nom;
	String prenom;
	String email;
	String motDePasse;
}
