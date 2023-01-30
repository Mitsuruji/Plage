package fr.orsys.projet.plage.initialisation;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import fr.orsys.projet.plage.business.Concessionnaire;
import fr.orsys.projet.plage.business.File;
import fr.orsys.projet.plage.business.LienDeParente;
import fr.orsys.projet.plage.business.Parasol;
import fr.orsys.projet.plage.business.Pays;
import fr.orsys.projet.plage.business.Statut;
import fr.orsys.projet.plage.dao.ConcessionnaireDAO;
import fr.orsys.projet.plage.dao.FileDAO;
import fr.orsys.projet.plage.dao.LienDeParenteDAO;
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

	private PasswordEncoder passwordEncoder;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		ajouterFiles();
		ajouterParasols();
		ajouterLiensDeParente();
		ajouterPays();
		ajouterStatuts();
		ajouterConcessionnaire();
	}

	private void ajouterFiles() {
		for (int i = 1; i <= 8; i++) {
			File file = new File();
			file.setNumero((byte) i);
			file.setPrixJournalier(180d - 10 * i);
			fileDAO.save(file);
		}
	}

	private void ajouterParasols() {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 10; j++) {
				Parasol parasol = new Parasol();
				parasol.setFile(fileDAO.findByNumero((byte) i));
				parasol.setNumEmplacement((byte) j);
				parasolDAO.save(parasol);
			}
		}
	}

	private void ajouterLiensDeParente() {
		lienDeParenteDAO.save(new LienDeParente("frère/sœur", 0.5f));
		lienDeParenteDAO.save(new LienDeParente("cousin/cousine", 0.25f));
		lienDeParenteDAO.save(new LienDeParente("aucun", 0f));
	}

	private void ajouterPays() {
		Pays france = new Pays("FR", "France");
		Pays italie = new Pays("IT", "Italie");
		Pays espagne = new Pays("ES", "Espagne");
		Pays allemagne = new Pays("DE", "Allemagne");
		Pays angleterre = new Pays("GB", "Angleterre");
		paysDAO.saveAll(Arrays.asList(france, italie, espagne, allemagne, angleterre));
	}

	private void ajouterStatuts() {
		Statut aTraiter = new Statut("A traiter");
		Statut confirmee = new Statut("Confirmée");
		Statut refusee = new Statut("Refusée");
		statutDAO.saveAll(Arrays.asList(aTraiter, confirmee, refusee));
	}

	private void ajouterConcessionnaire() {
		Concessionnaire concessionnaire = new Concessionnaire();
		concessionnaire.setEmail("peppe@orsys.fr");
		concessionnaire.setNumeroDeTelephone("+3912345678");
		concessionnaire.setMotDePasse(passwordEncoder.encode("12345678"));
		concessionnaireDAO.save(concessionnaire);
	}

}
