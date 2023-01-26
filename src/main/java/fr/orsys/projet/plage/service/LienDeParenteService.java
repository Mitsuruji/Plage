package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.dto.LienDeParenteDTO;

public interface LienDeParenteService {

	LienDeParente ajouterLienDeParente(String nom, float coefficient);
	
	LienDeParente enregisterLienDeParente(LienDeParente lienDeParente);
	
	LienDeParente enregisterLienDeParente(LienDeParenteDTO lienDeParenteDTO);
	
	List<LienDeParente> recupererLienDeParentes();
	
	Optional<LienDeParente> recupererLienDeParente(Long id);
	
	LienDeParente recupererLienDeParente(String nom);
	
	LienDeParente updateLienDeParente(String nom, float coefficient);
}
