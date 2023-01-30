package fr.orsys.projet.plage.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.orsys.projet.plage.business.Utilisateur;
import fr.orsys.projet.plage.dao.UtilisateurDAO;
import fr.orsys.projet.plage.exception.UtilisateurNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

	private UtilisateurDAO utilisateurDAO;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Utilisateur user = utilisateurDAO.findByEmail(email)
		        .orElseThrow(() -> new UtilisateurNotFoundException("L'utilisateur ayant cet email: " + email + "n'a pas été trouvé"));

		    return UserDetailsImpl.build(user);
	}

}
