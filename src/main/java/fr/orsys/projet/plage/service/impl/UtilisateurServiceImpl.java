package fr.orsys.projet.plage.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.dao.ConcessionnaireDAO;
import fr.orsys.projet.plage.dao.LocataireDAO;
import fr.orsys.projet.plage.dao.UtilisateurDAO;
import fr.orsys.projet.plage.dto.ConcessionnaireDTO;
import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.dto.UtilisateurDTO;
import fr.orsys.projet.plage.exception.FileExistantException;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import fr.orsys.projet.plage.mapper.ConcessionnaireMapper;
import fr.orsys.projet.plage.mapper.LocataireMapper;
import fr.orsys.projet.plage.mapper.UtilisateurMapper;
import fr.orsys.projet.plage.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	private final UtilisateurDAO utilsateurDAO;
	private final UtilisateurMapper utilisateurMapper;
	private final ConcessionnaireDAO concessionnaireDAO;
	private final ConcessionnaireMapper concessionnaireMapper;
	private final LocataireDAO locataireDAO;
	private final LocataireMapper locataireMapper;

	
	public UtilisateurServiceImpl(UtilisateurDAO utilsateurDAO, UtilisateurMapper utilisateurMapper,
			ConcessionnaireDAO concessionnaireDAO, ConcessionnaireMapper concessionnaireMapper,
			LocataireDAO locataireDAO, LocataireMapper locataireMapper) {
		this.utilsateurDAO = utilsateurDAO;
		this.utilisateurMapper = utilisateurMapper;
		this.concessionnaireDAO = concessionnaireDAO;
		this.concessionnaireMapper = concessionnaireMapper;
		this.locataireDAO = locataireDAO;
		this.locataireMapper = locataireMapper;
	}

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
	public List<LocataireDTO> getLocataires() {
		return locataireMapper.toDtos(locataireDAO.findAll());
	}

	@Override
	public UtilisateurDTO getUtilisateurById(Long id) {
		return utilisateurMapper.toDto(utilsateurDAO.findById(id)
				.orElseThrow(() -> new UtilisateurNotFoundException("Utilisateur d'identifiant " + id + " inexistant")));
	}

	@Override
	public UtilisateurDTO getUtilisateurByEmail(String email) {
		return utilisateurMapper.toDto(locataireDAO.findByEmail(email));
	}

	@Override
	public List<LocataireDTO> getLocatairesByPaysCode(String codePays) {
		return locataireMapper.toDtos(locataireDAO.findByPaysCode(codePays));
	}

	@Override
	public List<LocataireDTO> getLocatairesDeParenteId(Long idLienDeParente) {
		return locataireMapper.toDtos(locataireDAO.findByLienDeParenteId(idLienDeParente));
	}

	@Override
	public List<LocataireDTO> getLocatairesByDateHeureInscriptionDesc() {
		return locataireMapper.toDtos(locataireDAO.findAllByOrderByDateHeureInscriptionDesc());
	}

	@Override
	public LocataireDTO addLocataire(LocataireDTO locataireDTO) {
		Locataire locataire = locataireMapper.toEntity(locataireDTO);
		return locataireMapper.toDto(locataireDAO.save(locataire));
	}

	@Override
	public void deleteClient(Long id) {
		locataireDAO.deleteById(id);
	}

}
