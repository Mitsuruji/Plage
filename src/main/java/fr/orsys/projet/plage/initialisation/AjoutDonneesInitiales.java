package fr.orsys.projet.plage.initialisation;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.business.Locataire;
import fr.orsys.projet.plage.business.Location;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.business.Statut;
import fr.orsys.projet.plage.dao.ConcessionnaireDAO;
import fr.orsys.projet.plage.dao.FileDAO;
import fr.orsys.projet.plage.dao.LienDeParenteDAO;
import fr.orsys.projet.plage.dao.LocataireDAO;
import fr.orsys.projet.plage.dao.LocationDAO;
import fr.orsys.projet.plage.dao.ParasolDAO;
import fr.orsys.projet.plage.dao.PaysDAO;
import fr.orsys.projet.plage.dao.StatutDAO;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AjoutDonneesInitiales implements CommandLineRunner {

	private final FileDAO fileDAO;
	private final ParasolDAO parasolDAO;
	private final LienDeParenteDAO lienDeParenteDAO;
	private final PaysDAO paysDAO;
	private final StatutDAO statutDAO;
	private final ConcessionnaireDAO concessionnaireDAO;
	private final LocataireDAO locataireDAO;
	private final LocationDAO locationDAO;

	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		addFiles();
		addParasols();
		addLiensDeParentes();
		addlistPays();
		addStatuts();
		addConcessionnaire();
		addLocataire();
		addLocation();
	}

	private void addFiles() {
		for (int i = 1; i <= 8; i++) {
			File file = new File();
			file.setNumero((byte) i);
			file.setPrixJournalier(180D - 10 * i);
			fileDAO.save(file);
		}
	}

	private void addParasols() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 10; j++) {
				Parasol parasol = new Parasol();
				parasol.setFile(fileDAO.findByNumero((byte) i));
				parasol.setNumEmplacement((byte) j);
				parasolDAO.save(parasol);
			}
		}
	}

	private void addLiensDeParentes() {
		lienDeParenteDAO.save(new LienDeParente("frère/sœur", 0.5F));
		lienDeParenteDAO.save(new LienDeParente("cousin/cousine", 0.25F));
		lienDeParenteDAO.save(new LienDeParente("aucun", 0F));
	}

	private void addlistPays() {
		Pays france = new Pays("FR", "France");
		Pays italie = new Pays("IT", "Italie");
		Pays espagne = new Pays("ES", "Espagne");
		Pays allemagne = new Pays("DE", "Allemagne");
		Pays angleterre = new Pays("GB", "Angleterre");
		paysDAO.saveAll(Arrays.asList(france, italie, espagne, allemagne, angleterre));
	}

	private void addStatuts() {
		Statut aTraiter = new Statut("A traiter");
		Statut confirmee = new Statut("Confirmée");
		Statut refusee = new Statut("Refusée");
		statutDAO.saveAll(Arrays.asList(aTraiter, confirmee, refusee));
	}

	private void addConcessionnaire() {
		Concessionnaire concessionnaire = new Concessionnaire();
		concessionnaire.setEmail("peppe@orsys.fr");
		concessionnaire.setMotDePasse(passwordEncoder.encode("12345678"));
		concessionnaire.setNumeroDeTelephone("+3912345678");
		concessionnaireDAO.save(concessionnaire);
	}

	private void addLocataire() {
		Locataire locataire = new Locataire();
		locataire.setEmail("salih@orsys.fr");
		locataire.setMotDePasse(passwordEncoder.encode("12345678"));
		locataire.setDateHeureInscription(LocalDateTime.now());
		locataire.setPays(paysDAO.findByCode("FR"));
		locataire.setLienDeParente(lienDeParenteDAO.findByNom("aucun"));
		locataireDAO.save(locataire);
	}

	private void addLocation() {
		Location location = new Location();
		location.setDateHeureDebut(LocalDateTime.now().plusMonths(6));
		location.setDateHeureFin(LocalDateTime.now().plusMonths(6).plusDays(2));
		location.setRemarques("Vivement les vacances!");
		location.setConcessionnaire(concessionnaireDAO.findByEmail("peppe@orsys.fr"));
		Locataire locataire = locataireDAO.findByEmail("salih@orsys.fr");
		location.setLocataire(locataire);
		List<Parasol> parasols = Arrays.asList(
				parasolDAO.findByNumEmplacementAndFileNumero((byte) 1, (byte) 1),
				parasolDAO.findByNumEmplacementAndFileNumero((byte) 1, (byte) 2),
				parasolDAO.findByNumEmplacementAndFileNumero((byte) 1, (byte) 3));
		location.setParasols(parasols);
		locationDAO.save(location);
	}

}
