package fr.orsys.projet.plage.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@RequiredArgsConstructor
public class Pays {

	@Id
	@NonNull
	private String code;
	
	@Size(max = 100)
	@NotBlank(message="Merci de préciser le nom de votre pays")
	@NonNull
	private String nom;
	
	@JsonBackReference
	@OneToMany(mappedBy="pays", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Locataire> locataires;
}
