package app.iVoteHub.config;

import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import app.iVoteHub.services.CustomUserDetailsService;
import app.iVoteHub.services.CustomUserDetailsServiceImpl;

/**
 * 
 * @author Zachary Ishmael
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomUserDetailsServiceImpl service = new CustomUserDetailsServiceImpl();
	@Override
	protected void configure(HttpSecurity https) throws Exception {
		//no authetication for home and login pages
		https.addFilterBefore(addCustomAuthFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.antMatchers("/home","/login").permitAll()
			.anyRequest().authenticated() //requires authenticated access 
			
			.and().formLogin()
			.loginPage("/login")
			.passwordParameter("password")
			.usernameParameter("username")
			.defaultSuccessUrl("/home", true)
			.loginProcessingUrl("/authentication")
			.failureHandler(new SimpleUrlAuthenticationFailureHandler("/login-error"))
			
			
			
			//Trying Different Approach
//			.and().formLogin()
//			.loginPage("/Voter/v-login")
//			.passwordParameter("password")
//			.usernameParameter("username")
//			.defaultSuccessUrl("/home",true)
//			.loginProcessingUrl("Voter/authentication")
//			
//			.and().formLogin()
//			.loginPage("/Candidate/c-login")
//			.passwordParameter("c-password")
//			.usernameParameter("c-username")
//			.defaultSuccessUrl("/home",true)
//			.loginProcessingUrl("/Candidate/authentication")
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
	 * {@link BCryptPasswordEncoder} and a {@link CustomUserDetailsServiceImpl}.
	 */
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception {

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		CustomUserDetailsAuthenticationProvider provider = new CustomUserDetailsAuthenticationProvider(encoder,service);
		auth.authenticationProvider(provider);
	}
	
	
	public CustomAuthenticationFilter addCustomAuthFilter() throws Exception {
		CustomAuthenticationFilter authFilter = new CustomAuthenticationFilter();
		authFilter.setAuthenticationFailureHandler(
		new SimpleUrlAuthenticationFailureHandler("/login-error")
		);
		return authFilter;
	}
	
}
