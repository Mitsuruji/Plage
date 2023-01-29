package fr.orsys.projet.plage.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.dao.LocataireDAO;
import fr.orsys.projet.plage.dto.LocataireDTO;
import fr.orsys.projet.plage.mapper.LocataireMapper;
import fr.orsys.projet.plage.service.LocataireService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocataireServiceImpl implements LocataireService {

	private final LocataireDAO locataireDAO;
	private final LocataireMapper locataireMapper;

	@Override
	public List<LocataireDTO> getLocataires() {
		return locataireMapper.toDtos(locataireDAO.findAll());
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
	public void deleteLocataire(Long id) {
		locataireDAO.deleteById(id);
	}

}