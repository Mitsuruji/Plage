package fr.orsys.projet.plage.business;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "files")
public class File {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	
	private byte numero;
	
	@Column(name = "prix_journalier")
	@PositiveOrZero
	private double prixJournalier;
	
	@OneToMany(mappedBy="file", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Parasol> parasols;
}
