package fr.orsys.projet.plage.business;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Locataire extends Utilisateur{
    
    @Column(name = "date_heure_inscription")
    private LocalDateTime dateHeureInscription;
    
    
    @OneToMany(mappedBy="locataire", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Location> locations;
    
    @ManyToOne
    private Pays pays;

    @ManyToOne
    private LienDeParente lienDeParente;
}
