package app.iVoteHub.config;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationToken extends UsernamePasswordAuthenticationToken{

	private String usertype;
	public CustomAuthenticationToken(Object principal, Object credentials, String usertype) {
		super(principal, credentials);
		this.usertype = usertype;
		super.setAuthenticated(false);
		//implementations always advised to set false - only allowed to be true when using 
		//Granted authorities implementation - see super class definition
	}
	
	public CustomAuthenticationToken (Object principal, Object credentials, String usertype, Collection<? extends GrantedAuthority> authorities ) {
		super(principal,credentials,authorities);
		this.usertype = usertype;
		super.setAuthenticated(true);
	}

	public String getUsertype () {
		return this.usertype;
	}
}
