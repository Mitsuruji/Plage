package fr.orsys.projet.plage.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Concessionnaire extends Utilisateur{
	
	public Concessionnaire(String numeroDeTelephone) {
		this.numeroDeTelephone = numeroDeTelephone;
	}

	@Column(name = "numero_de_telephone")
	@Pattern(regexp="^[0-9]{10}$|^\\+[0-9]{1,3} ?[0-9]{4,14}$")
	private String numeroDeTelephone;

}
