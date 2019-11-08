package app.iVoteHub.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 * @author Zachary Ishmael
 * A class for custom authentication filtering.
 * Extends spring security to provide extra login field
 * for user differentiation at login, so that login will only work
 * for a user of the appropriate (matching) type.
 *
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	/*Additional login field to be filtered*/
	public static final String SPRING_SECURITY_FORM_USERTYPE_KEY = "usertype";
	
	private String usertypeParameter = SPRING_SECURITY_FORM_USERTYPE_KEY;
	
	@Override
	public  Authentication attemptAuthentication (
			HttpServletRequest request, HttpServletResponse response) 
					throws AuthenticationException 
	{
		
		if (notPost(request)) { //only accepts POST requests for authentication purposes.
			throw new AuthenticationServiceException(
					"Authentication error: "+ request.getMethod() + " request is not secure."
					);
		}
		
		CustomAuthenticationToken authRequest = getAuthRequest(request);
		setDetails(request,authRequest);
		
		return this.getAuthenticationManager().authenticate(authRequest);
		
	}
	
	/**
	 * Method to set a new CustomAuthentication token from Httprequest instance.
	 * Essentially take parameters of the request and stores them in an
	 * CustomAthenticationToken.
	 * @param request
	 * @return
	 */
	private CustomAuthenticationToken getAuthRequest(HttpServletRequest request) {
		
		String username = obtainUsername(request);
		String password = obtainPassword(request);
		String usertype = obtainUsertype(request);
		
		if (username == null) {
			username = "";
		}
		if (password == null) {
			password = "";
		}
		if (usertype == null) {
			usertype = "";
		}
	
		return new CustomAuthenticationToken(username, password, usertype);
		
	}

	/**
	 * Return the usertype requestParameter.
	 * @param request
	 * @return usetype request parameter
	 */
	private String obtainUsertype(HttpServletRequest request) {
		return request.getParameter(usertypeParameter);
	}
	
	public boolean notPost(HttpServletRequest request) {
		if (!request.getMethod().equals("POST")) {return true;}
		else {return false;}
	}
}
