package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.dao.LienDeParenteDAO;
import fr.orsys.projet.plage.dto.LienDeParenteDTO;
import fr.orsys.projet.plage.exception.LienDeParenteExistantException;
import fr.orsys.projet.plage.exception.LienDeParenteInexistantException;
import fr.orsys.projet.plage.mapper.LienDeParenteMapper;
import fr.orsys.projet.plage.service.LienDeParenteService;

public class LienDeParenteServiceImpl implements LienDeParenteService {

	private LienDeParenteDAO lienDeParenteDAO;
	private LienDeParenteMapper lienDeParenteMapper;
	
	@Override
	public LienDeParente ajouterLienDeParente(String nom, float coefficient) {
		if (lienDeParenteDAO.existsByNom(nom)) {
			throw new LienDeParenteExistantException("Ce lien de parente est déjà présent en base");
		}
		return lienDeParenteDAO.save(new LienDeParente(nom, coefficient));
	}

	@Override
	public LienDeParente enregisterLienDeParente(LienDeParente lienDeParente) {
		return lienDeParenteDAO.save(lienDeParente);
	}

	@Override
	public LienDeParente enregisterLienDeParente(LienDeParenteDTO lienDeParenteDTO) {
		LienDeParente lienDeParente = lienDeParenteMapper.toEntity(lienDeParenteDTO);
		return enregisterLienDeParente(lienDeParente);
	}

	@Override
	public List<LienDeParente> recupererLienDeParentes() {
		return lienDeParenteDAO.findAll();
	}

	@Override
	public Optional<LienDeParente> recupererLienDeParente(Long id) {
		return lienDeParenteDAO.findById(id);
	}

	@Override
	public LienDeParente recupererLienDeParente(String nom) {
		return lienDeParenteDAO.findByNom(nom);
	}

	@Override
	public LienDeParente updateLienDeParente(String nom, float coefficient) {
		if (!lienDeParenteDAO.existsByNom(nom)) {
			throw new LienDeParenteInexistantException("Ce lien de parenté n'existe pas en base");
		}
		LienDeParente lienDeParente = recupererLienDeParente(nom);
		lienDeParente.setCoefficient(coefficient);
		return lienDeParenteDAO.save(lienDeParente);
	}

}
