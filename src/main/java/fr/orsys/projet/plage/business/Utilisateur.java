package fr.orsys.projet.plage.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public abstract class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
  
    @Column(name = "nom")
    protected String nom;
  
    @Column(name = "prenom")
    protected String prenom;

	@Email
	@NotBlank
    @Column(name = "email", unique= true)
	protected String email;
	
    @Column(name = "mot_de_passe")
    protected String motDePasse;
}
