package fr.orsys.projet.plage.service;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.dto.LienDeParenteDTO;


public interface LienDeParenteService {

	LienDeParente addLienDeParente(String nom, float coefficient);
	
	LienDeParente saveLienDeParente(LienDeParente lienDeParente);
	
	LienDeParente saveLienDeParente(LienDeParenteDTO lienDeParenteDTO);
	
	List<LienDeParenteDTO> getLienDeParentes();
	
	Optional<LienDeParente> getLienDeParente(Long id);
	
	LienDeParente getLienDeParente(String nom);
	
	LienDeParente updateLienDeParente(String nom, float coefficient);
}
