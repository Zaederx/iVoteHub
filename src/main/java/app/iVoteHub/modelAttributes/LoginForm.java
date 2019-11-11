package app.iVoteHub.modelAttributes;


public class LoginForm {

	private String usertype;
	
	private String username;
	
	private String password;

	
	
	/**
	 * @return the usertype
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype - the usertype to set
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

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
}
