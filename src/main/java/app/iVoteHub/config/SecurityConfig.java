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
		https
			.requiresChannel()
			.anyRequest()
			.requiresSecure()
			
		.and().authorizeRequests()
		.antMatchers("/","/preprocessing","/login","/register-voter-form","/register","/home","/register/**",VAddressBook.REGISTRATION.configUrl(),VAddressBook.LOGIN.configUrl()).permitAll()
		
		.and().authorizeRequests()
			.antMatchers("/voter/**").hasRole(Role.VOTER.toString())//note: because hasRole appends "ROLE_" to what ever string provided
			.antMatchers("/commision/**", "/commission-rest/**").hasRole(Role.ELECTIONCOMMISSION.toString()).anyRequest().authenticated() //requires authenticated access 
		
		.and().formLogin() 
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/logged-user",true)
				.failureUrl("/login?error")
				.passwordParameter("password")
				.usernameParameter("username")
				.loginProcessingUrl("/authenticate").failureForwardUrl("/login-error")
				.failureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error"))//calls this url authentication fails
		
		.and().rememberMe()
		.key("98HERF9HER9UHEFIJNSDOIUVERJNF0EHRG8EFVAEY0BRFBC")
		.rememberMeParameter("remember")
		.rememberMeCookieName("iVoteHub")
		.rememberMeCookieDomain("localhost")
		.tokenValiditySeconds(172800)//2 days
		
		.and().logout()
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID","iVoteHub")//deletes cookies
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/login")
			.logoutSuccessUrl("/logout-success")
			.permitAll()
		
		
		.and().exceptionHandling().accessDeniedPage("/login-error")
		; 
	}
	
	
	@Override
	public void configure (AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("cofigure authenticationManager - Security Config");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		auth.userDetailsService(service).passwordEncoder(encoder);
	}
	

	
}
