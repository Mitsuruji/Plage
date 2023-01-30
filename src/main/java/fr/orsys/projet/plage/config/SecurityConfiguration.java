//package fr.orsys.projet.plage.config;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import fr.orsys.projet.plage.config.security.JwtAuthTokenFilter;
//import lombok.AllArgsConstructor;
//
//@Configuration
//@AllArgsConstructor
//@EnableGlobalMethodSecurity(
//	    // securedEnabled = true,
//	    // jsr250Enabled = true,
//	    prePostEnabled = true)
//public class SecurityConfiguration {
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//
//	@Bean
//	public JwtAuthTokenFilter authenticationJwtTokenFilter() {
//		return new JwtAuthTokenFilter();
//	}
//
////	@Bean
////	public UserDetailsService userDetailsService() {
////	    return super.userDetailsServiceBean();
////	}
//	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(passwordEncoder());
//
//		return authProvider;
//	}
//
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable()
//				.authorizeRequests()
//				.antMatchers("/api/utilisateur/**",
//								"/v3/api-docs/**",
//								"/swagger-resources",
//								"/swagger-resources/**",
//								"/configuration/ui",
//								"/configuration/security",
//								"/swagger-ui/**",
//								"/webjars/**",
//								"/swagger-ui").permitAll()
//				.anyRequest().authenticated()
//				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//		// fix H2 database console: Refused to display ' in a frame because it set
//		// 'X-Frame-Options' to 'deny'
////		http.headers().frameOptions().sameOrigin();
//
//		http.authenticationProvider(authenticationProvider());
//
//		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
//		return http.build();
//	}
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
//		return authConfig.getAuthenticationManager();
//	}
//
//}