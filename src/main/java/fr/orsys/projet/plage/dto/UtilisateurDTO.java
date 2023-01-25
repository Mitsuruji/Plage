package fr.orsys.projet.plage.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UtilisateurDTO {

	Long id;
	String nom;
	String prenom;
	String email;
	String motDePasse;
}
