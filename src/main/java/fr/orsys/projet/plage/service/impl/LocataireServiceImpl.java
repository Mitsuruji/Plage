package fr.orsys.projet.plage.service.impl;

import java.util.List;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.dao.LocataireDAO;
import fr.orsys.projet.plage.exception.LocataireNotFoundException;
import fr.orsys.projet.plage.service.LocataireService;

public class LocataireServiceImpl implements LocataireService {

	private LocataireDAO locataireDAO;

	public LocataireServiceImpl(LocataireDAO locataireDAO) {
		this.locataireDAO = locataireDAO;
	}

	@Override
	public List<Locataire> getLocataires() {
		return locataireDAO.findAll();
	}

	@Override
	public Locataire getLocataireById(Long id) {
		return locataireDAO.findById(id)
				.orElseThrow(() -> new LocataireNotFoundException("Locataire d'identifiant " + id + " inexistant"));
	}

	@Override
	public Locataire getLocataireByEmail(String email) {
		return locataireDAO.findByEmail(email);
	}

	@Override
	public List<Locataire> getLocatairesByPays(String codePays) {
		return locataireDAO.findByPaysCode(codePays);
	}

	@Override
	public List<Locataire> getLocatairesByLienParente(Long idLienParente) {
		return locataireDAO.findByLienParenteId(idLienParente);
	}

	@Override
	public List<Locataire> getLocatairesBySateHeureInscription(String order) {
		return locataireDAO.findByOrderBydateHeureInscription(order);
	}

	@Override
	public Locataire addLocataire(Locataire locataire) {
		return locataireDAO.save(locataire);
	}

	@Override
	public void deleteClient(Long id) {
		locataireDAO.deleteById(id);
	}

}
