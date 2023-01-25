package fr.orsys.projet.plage.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public abstract class Utilisateur {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(name = "nom")
    private String nom;
  
    @Column(name = "prenom")
    private String prenom;

	@Email
	@NotBlank
    @Column(name = "email")
    private String email;
  
    @Column(name = "mot_de_passe")
    private String motDePasse;
}
