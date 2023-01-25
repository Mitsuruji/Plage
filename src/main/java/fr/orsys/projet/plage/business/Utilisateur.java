package fr.orsys.projet.plage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(name = "nom")
    private String nom;
  
    @Column(name = "prenom")
    private String prenom;
  
    @Column(name = "email")
    private String email;
  
    @Column(name = "mot_de_passe")
    private String motDePasse;
}
