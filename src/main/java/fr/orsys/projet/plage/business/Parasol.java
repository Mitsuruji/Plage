package fr.orsys.projet.plage.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "parasols")
public class Parasol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "num_emplacement")
	private byte numEmplacement;

	@ManyToMany(mappedBy = "parasols")
	private List<Location> locations;

	@ManyToOne
	@NotNull
	private File file;

	public Parasol(byte numEmplacement) {
		this.numEmplacement = numEmplacement;
	}
}
