package fr.orsys.projet.plage.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
public class LocataireDTO  extends UtilisateurDTO{

	Long id;
	LocalDateTime dateHeureInscription;
	@JsonIgnore
	List<LocationDTO> locations;
	PaysDTO pays;
	LienDeParenteDTO lienDeParente;

}
