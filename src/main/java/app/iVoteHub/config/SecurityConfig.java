package app.iVoteHub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import app.iVoteHub.addressEnums.Role;
import app.iVoteHub.addressEnums.VAddressBook;
import app.iVoteHub.services.GeneralUserDetailsService;

/**
 * 
 * @author Zachary Ishmael
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	VAddressBook v;
	@Autowired
	UserDetailsService service;
	@Override
	protected void configure(HttpSecurity https) throws Exception {
		//no authetication for home and login pages
//		https.addFilterBefore(addCustomAuthFilter(), UsernamePasswordAuthenticationFilter.class)
		https
			.requiresChannel()
			.anyRequest()
			.requiresSecure()
			
		.and().authorizeRequests()
		.antMatchers("/register-voter-form","/register","/home","/register/**", VAddressBook.REGISTRATION.configUrl(),VAddressBook.LOGIN.configUrl()).permitAll()
		
		.and().authorizeRequests()
			.antMatchers("/voter/**").hasRole(Role.VOTER.toString())//note: because hasRole appends "ROLE_" to what ever string provided
			.antMatchers("/candidate/**").hasRole(Role.CANDIDATE.toString()).anyRequest().authenticated() //requires authenticated access 
		
		.and().formLogin() 
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/logged-user",true)
				.failureUrl("/login-error").permitAll()
				.passwordParameter("password")
				.usernameParameter("username")
	//			.defaultSuccessUrl("/home", true)
				.loginProcessingUrl("/authenticate").failureForwardUrl("/login-error")
				.failureHandler(new SimpleUrlAuthenticationFailureHandler("/login-error"))
			
		.and().logout()
			.invalidateHttpSession(true)
			.deleteCookies("SESSION")//deletes Spring default cookies
//			.clearAuthentication(true)
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/logout-success")
			.permitAll()
		
		.and().exceptionHandling().accessDeniedPage("/login-error")
		; 
	}
	
//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		MessageDigest digest = MessageDigest.getInstance("SHA-256");
//		auth.userDetailsService().passwordEncoder(digest);
//		//Note - SHA is no longer secure - BCrypt recommended
//		//byte[] hash = digest.digest(digest.getBytes("UTF-8"));
//	}
	
	/**
	 * Implements the {@link WebSecurityConfigurerAdapter} configure method.
	 * Configures the @{@link AuthenticationManagerBuilder} with the 
	 * {@link CustomUserDetailsAuthenticationProvider} that has been set with the
	 * {@link BCryptPasswordEncoder} and a {@link CustomUserDetailsService}.
	 */
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("cofigure authenticationManager - Security Config");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	

	
}
