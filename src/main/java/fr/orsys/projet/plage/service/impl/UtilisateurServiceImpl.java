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
		return utilisateurMapper.toDto(utilsateurDAO.findById(id).orElseThrow(
				() -> new UtilisateurNotFoundException("Utilisateur d'identifiant " + id + " inexistant")));
	}

	@Override
	public UtilisateurDTO getUtilisateurByEmailAndMotDePasse(String email, String motDePasse) {
		UtilisateurDTO utilisateurDTO = utilisateurMapper
				.toDto(utilsateurDAO.findByEmailAndMotDePasse(email, motDePasse));
		if (utilisateurDTO == null) {
			throw new UtilisateurNotFoundException("Email et mot de passe invalides");
		}
		return utilisateurDTO;
	}

	@Override
	public void saveUtilisateur(UtilisateurDTO utilisateurDTO) {
		utilsateurDAO.save(utilisateurMapper.toEntity(utilisateurDTO));

	}

}
