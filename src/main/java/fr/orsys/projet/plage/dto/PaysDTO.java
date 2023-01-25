package fr.orsys.projet.plage.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaysDTO {

	String code;
	String nom;
	
	@OneToMany(mappedBy="pays", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	List<LocataireDTO> locatairesDTO;
}
