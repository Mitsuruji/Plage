package fr.orsys.projet.plage.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "liens_de_parente")
public class LienDeParente {

	public LienDeParente(String nom, float coefficient) {
		this.nom = nom;
		this.coefficient = coefficient;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Size(max = 50)
	@NotBlank(message="Merci de préciser le nom du lien de parenté")
	private String nom;
	
	@PositiveOrZero
	private float coefficient;
}
