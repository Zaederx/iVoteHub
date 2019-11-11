package app.iVoteHub.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import app.iVoteHub.services.GeneralUserDetailsService;

/**
 * 
 * @author Zachary Ishmael
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	GeneralUserDetailsService service;
	@Override
	protected void configure(HttpSecurity https) throws Exception {
		//no authetication for home and login pages
//		https.addFilterBefore(addCustomAuthFilter(), UsernamePasswordAuthenticationFilter.class)
		https
		.authorizeRequests()
			.anyRequest().authenticated() //requires authenticated access 
			
			.and().formLogin()
//			.loginPage("/login")
			.permitAll().defaultSuccessUrl("/login-success",true).failureUrl("/login-error").permitAll()
			.passwordParameter("password")
			.usernameParameter("username")
//			.defaultSuccessUrl("/home", true)
			.loginProcessingUrl("/authentication").defaultSuccessUrl("/home", true).failureForwardUrl("/login-error")
			.failureHandler(new SimpleUrlAuthenticationFailureHandler("/login-error"))
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
