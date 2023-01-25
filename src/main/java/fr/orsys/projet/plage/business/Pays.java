package fr.orsys.projet.plage.business;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Pays {

	@Id
	private String code;
	
	@Size(max = 100)
	@NotBlank(message="Merci de préciser le nom de votre pays")
	private String nom;
	
	@ManyToMany(mappedBy = "locataires")
	private List<Locataire> locataires;
}
