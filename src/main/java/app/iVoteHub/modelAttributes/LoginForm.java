package app.iVoteHub.modelAttributes;


public class LoginForm {


	
	private String username;
	
	private String password;

	/*Value representing whether user
	 * wishes to be remebered if 
	 * site is left without logging out*/
	private boolean remember;
	

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username - form login username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password - form login password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 
	 * @return whether the user wants
	 * to be remebered if not logged out.
	 */
	public boolean isRemember() {
		return remember;
	}

	/**
	 * 
	 * @param rememberMe 
	 */
	public void setRemember(boolean rememberMe) {
		this.remember = rememberMe;
	}
}
