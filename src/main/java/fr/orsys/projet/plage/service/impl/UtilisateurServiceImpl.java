package fr.orsys.projet.plage.service.impl;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.dao.UtilisateurDAO;
import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import fr.orsys.projet.plage.mapper.UtilisateurMapper;
import fr.orsys.projet.plage.service.UtilisateurService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {

	private final UtilisateurDAO utilsateurDAO;
	private final UtilisateurMapper utilisateurMapper;

	@Override
	public UtilisateurDTO getUtilisateurById(Long id) {
		return utilisateurMapper.toDto(utilsateurDAO.findById(id)
				.orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur d'identifiant " + id + " inexistant")));
	}

	@Override
	public UtilisateurDTO getUtilisateurByEmail(String email) {
		return utilisateurMapper.toDto(utilsateurDAO.findByEmail(email));
	}


}
