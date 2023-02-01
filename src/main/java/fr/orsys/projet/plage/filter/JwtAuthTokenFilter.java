package fr.orsys.projet.plage.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import fr.orsys.projet.plage.service.impl.UserDetailsServiceImpl;
import fr.orsys.projet.plage.util.JwtGeneratorService;

public class JwtAuthTokenFilter extends OncePerRequestFilter{

	@Autowired
	private JwtGeneratorService jwtGeneratorService;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthTokenFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
		      String jwt = parseJwt(request);
		      if (jwt != null && jwtGeneratorService.validateJwtToken(jwt)) {
		        String username = jwtGeneratorService.getEmailFromJwtToken(jwt);

		        UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(username);
		        
		        UsernamePasswordAuthenticationToken authentication = 
		            new UsernamePasswordAuthenticationToken(userDetails,
		                                                    null,
		                                                    userDetails.getAuthorities());
		        
		        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		        SecurityContextHolder.getContext().setAuthentication(authentication);
		      }
		    } catch (Exception e) {
		      logger.error("Cannot set user authentication: {}", e);
		    }

		    filterChain.doFilter(request, response);
		  }

		  private String parseJwt(HttpServletRequest request) throws ServletException {
		    return jwtGeneratorService.getJwtFromLocalStorage(request);
		  }
	
	
}
