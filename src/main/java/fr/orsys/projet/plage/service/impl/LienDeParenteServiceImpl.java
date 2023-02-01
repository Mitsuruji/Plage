package fr.orsys.projet.plage.service.impl;


@Service
public class LienDeParenteServiceImpl implements LienDeParenteService {

	private LienDeParenteDAO lienDeParenteDAO;
	private LienDeParenteMapper lienDeParenteMapper;
	
	@Override
	public LienDeParente addLienDeParente(String nom, float coefficient) {
		if (lienDeParenteDAO.existsByNom(nom)) {
			throw new LienDeParenteExistException("Ce lien de parente est déjà présent en base");
		}
		return lienDeParenteDAO.save(new LienDeParente(nom, coefficient));
	}

	@Override
	public LienDeParente saveLienDeParente(LienDeParente lienDeParente) {
		return lienDeParenteDAO.save(lienDeParente);
	}

	@Override
	public LienDeParente saveLienDeParente(LienDeParenteDTO lienDeParenteDTO) {
		LienDeParente lienDeParente = lienDeParenteMapper.toEntity(lienDeParenteDTO);
		return saveLienDeParente(lienDeParente);
	}

	@Override
	public List<LienDeParente> getLienDeParentes() {
		return lienDeParenteDAO.findAll();
	}

	@Override
	public Optional<LienDeParente> getLienDeParente(Long id) {
		return lienDeParenteDAO.findById(id);
	}

	@Override
	public LienDeParente getLienDeParente(String nom) {
		return lienDeParenteDAO.findByNom(nom);
	}

	@Override
	public LienDeParente updateLienDeParente(String nom, float coefficient) {
		if (!lienDeParenteDAO.existsByNom(nom)) {
			throw new LienDeParenteNotFoundException("Ce lien de parenté n'existe pas en base");
		}
		LienDeParente lienDeParente = getLienDeParente(nom);
		lienDeParente.setCoefficient(coefficient);
		return lienDeParenteDAO.save(lienDeParente);
	}

}
