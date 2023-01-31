package fr.orsys.projet.plage.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import fr.orsys.projet.plage.validators.UniqueLocationParasolByTime;
import fr.orsys.projet.plage.validators.DateHeureDebutBeforeDateHeureFinConstraint;
import fr.orsys.projet.plage.validators.SaisonEstivale;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@DateHeureDebutBeforeDateHeureFinConstraint
@UniqueLocationParasolByTime
@Table(name = "locations")
public class Location {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @SaisonEstivale
    @Column(name = "date_heure_debut")
    private LocalDateTime dateHeureDebut;
  
    @SaisonEstivale
    @Column(name = "date_heure_fin")
    private LocalDateTime dateHeureFin;
  
    @Column(name = "montant_a_regler_en_euros")
    private Double montantAReglerEnEuros;
  
    @Column(name = "remarques")
    private String remarques;
    
    @JsonManagedReference
    @ManyToOne
    private Locataire locataire;
    
    @ManyToOne
    private Statut statut;
    
    @ManyToOne
    private Concessionnaire concessionnaire;
    
    @JsonManagedReference
    @ManyToMany
    private List<Parasol> parasols;
    
}
