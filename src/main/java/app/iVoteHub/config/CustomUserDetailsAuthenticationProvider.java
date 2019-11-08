package app.iVoteHub.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import app.iVoteHub.services.CustomUserDetailsService;

/**
 * 
 * @author Zachary Ishmael
 * 
 * A custom implementation of the {@link AbstractUserDetailsAuthenticationProvider}.
 * Based on Spring's {@link DaoAuthenticationProvider} implementation,
 * this class provides security checks of user credentials, by retrieving UserDetails
 * via Spring Boot auto configuration from CustomUserServiceDetials implementation.
 *
 */
public class CustomUserDetailsAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{
	
	/*Needed to avoid possible encoder short circuit*/
	public static final String USER_NOT_FOUND = "userNotFoundPassword";
	
	/*Needed to avoid possible encoder short circuit*/
	private String userNotFoundEncoded;

	private PasswordEncoder encoder;
	
	private CustomUserDetailsService userDetailsService;


	public CustomUserDetailsAuthenticationProvider(PasswordEncoder encoder, CustomUserDetailsService userDetailsService) {
		this.encoder = encoder;
		this.userDetailsService = userDetailsService;
	}
	/**
	 * Does a stand security check of user credentials.
	 * Checks whether the password entered by the user at login
	 * matches the password store for that user in the database.
	 */
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		if (authentication.getCredentials() == null) {
			logger.debug("No credentails given");
			throw new BadCredentialsException("CustomAuthentication class: No credentials given.");
		}
		
		String loginPassword = authentication.getCredentials().toString();
		String userPassword = userDetails.getPassword();
		
		if (!passwordsMatch(loginPassword,userPassword)) {
			logger.debug("CustomAuthentication class: password entered does not match user's password.");
			throw new BadCredentialsException("CustomAuthentication class: passwords do not match.");
		}
		
	}


	/**
	 * From the InitialisingBean interface: </br>
	 * "This method allows the bean instance to perform validation of 
	 * its overall configuration and final initialization 
	 * when all bean properties have been set."
	 * 
	 * In other words, when all beans are set, this method runs
	 * to check that reqired fields or properties have been set
	 * [usually meaning are not null].
	 */
	@Override 
	protected void doAfterPropertiesSet() {
		try {
			super.doAfterPropertiesSet();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.notNull(userDetailsService,"UserDetailsService currently not set: Please set UserDetailsService");
		this.userNotFoundEncoded = this.encoder.encode(USER_NOT_FOUND);
	
	}
	
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		String [] user = username.split(":");
		UserDetails details = null;
		
		try {
			details = this.userDetailsService.loadUserByUsernameAndUsertype(user[0], user[1]);
			if (details == null) {
				throw new InternalAuthenticationServiceException("Error: UserDetails cannot return null.");
			}
		} catch (UsernameNotFoundException e) {
			/*Extends process time to roughly equal successful a username match time
			 *  - to reduce likelihood  timing hacker attacks*/
			if (authentication.getCredentials() != null) {
				String loginPassword = authentication.getCredentials().toString();
				this.encoder.matches(loginPassword, this.userNotFoundEncoded);
			}
		} catch (InternalAuthenticationServiceException e) {
			logger.debug(e.getStackTrace());
		}
		catch (Exception e) {
			logger.debug("Error retrieving User: "+ e.getStackTrace());
		}
		return details;
	}

	/**
	 * Checks whether password from login page, matches user's password.
	 * @param loginPassword - password enter by user at login page.
	 * @param userPassword - password associated with user in Database.
	 * @return true if they match, false if they don't.
	 */
	protected boolean passwordsMatch (String loginPassword, String userPassword) {
		if (encoder.matches(loginPassword, userPassword)) {return true;}
		return false;
	}

}
