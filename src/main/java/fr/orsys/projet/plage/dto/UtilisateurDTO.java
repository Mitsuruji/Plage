package fr.orsys.projet.plage.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = LocataireDTO.class, name = "locataire"),
    @JsonSubTypes.Type(value = ConcessionnaireDTO.class, name = "concessionnaire")})
public abstract class UtilisateurDTO {	
	String nom;
	String prenom;
	String email;
	String motDePasse;
}
