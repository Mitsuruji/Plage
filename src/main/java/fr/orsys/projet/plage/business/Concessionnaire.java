package fr.orsys.projet.plage.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Concessionnaire extends Utilisateur{

	@Column(name = "numero_de_telephone")
	@Pattern(regexp="^\\d{10}$|^\\+\\d{1,3} ?\\d{4,14}$")
	private String numeroDeTelephone;

}
