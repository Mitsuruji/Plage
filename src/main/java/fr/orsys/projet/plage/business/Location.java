package fr.orsys.projet.plage.model;

import java.time.LocalDateTime;

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
@Table(name = "locations")
public class Location {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    @Column(name = "date_heure_debut")
    private LocalDateTime dateHeureDebut;
  
    @Column(name = "date_heure_fin")
    private LocalDateTime dateHeureFin;
  
    @Column(name = "montant_a_regler_en_euros")
    private double montantAReglerEnEuros;
  
    @Column(name = "remarques")
    private String remarques;
}
