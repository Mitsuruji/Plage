package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Utilisateur;
import fr.orsys.projet.plage.dao.ConcessionnaireDAO;
import fr.orsys.projet.plage.dao.LocataireDAO;
import fr.orsys.projet.plage.dao.UtilisateurDAO;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.exception.FileExistantException;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import fr.orsys.projet.plage.mapper.ConcessionnaireMapper;
import fr.orsys.projet.plage.mapper.LocataireMapper;
import fr.orsys.projet.plage.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurDAO utilsateurDAO;
	private ConcessionnaireDAO concessionnaireDAO;
	private ConcessionnaireMapper concessionnaireMapper;
	private LocataireDAO locataireDAO;
	private LocataireMapper locataireMapper;
	
	
	
	@Override
	public Concessionnaire ajouterConcessionnaire(String numeroDeTelephone) {
		if (concessionnaireDAO.existsByNumeroDeTelephone(numeroDeTelephone)) {
			throw new FileExistantException("Ce concessionnaire est déjà présent en base");
		}
		return concessionnaireDAO.save(new Concessionnaire(numeroDeTelephone));
	}

	@Override
	public Concessionnaire enregisterConcessionnaire(Concessionnaire concessionnaire) {
		return concessionnaireDAO.save(concessionnaire);
	}

	@Override
	public Concessionnaire enregisterConcessionnaire(ConcessionnaireDTO concessionnaireDTO) {
		Concessionnaire concessionnaire = concessionnaireMapper.toEntity(concessionnaireDTO);
		return enregisterConcessionnaire(concessionnaire);
	}

	@Override
	public List<Concessionnaire> recupererConcessionnaires() {
		return concessionnaireDAO.findAll();
	}

	@Override
	public Optional<Concessionnaire> recupererConcessionnaire(Long id) {
		return concessionnaireDAO.findById(id);
	}

	@Override
	public Concessionnaire recupererConcessionnaire(String numeroDeTelephone) {
		return concessionnaireDAO.findByNumeroDeTelephone(numeroDeTelephone);
	}

	@Override
	public Concessionnaire updateConcessionnaire(String numeroDeTelephone) {
		if (!concessionnaireDAO.existsByNumeroDeTelephone(numeroDeTelephone)) {
			throw new UtilisateurNotFoundException("Ce concessionnaire n'existe pas en base");
		}
		Concessionnaire concessionnaire = recupererConcessionnaire(numeroDeTelephone);
		concessionnaire.setNumeroDeTelephone(numeroDeTelephone);
		return concessionnaireDAO.save(concessionnaire);
	}

	@Override
	public List<Locataire> getLocataires() {
		return locataireDAO.findAll();
	}

	@Override
	public Utilisateur getUtilisateurById(Long id) {
		return utilsateurDAO.findById(id)
				.orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur d'identifiant " + id + " inexistant"));
	}

	@Override
	public Utilisateur getUtilisateurByEmail(String email) {
		return locataireDAO.findByEmail(email);
	}

	@Override
	public List<Locataire> getLocatairesByPaysCode(String codePays) {
		return locataireDAO.findByPaysCode(codePays);
	}

	@Override
	public List<Locataire> getLocatairesDeParenteId(Long idLienDeParente) {
		return locataireDAO.findByLienDeParenteId(idLienDeParente);
	}

	@Override
	public List<Locataire> getLocatairesByDateHeureInscriptionDesc() {
		return locataireDAO.findAllByOrderByDateHeureInscriptionDesc();
	}

	@Override
	public Locataire addLocataire(LocataireDTO locataireDTO) {
	    Locataire locataire = locataireMapper.toEntity(locataireDTO);
	    return locataireDAO.save(locataire);
	}

	@Override
	public void deleteClient(Long id) {
		locataireDAO.deleteById(id);
	}

}
