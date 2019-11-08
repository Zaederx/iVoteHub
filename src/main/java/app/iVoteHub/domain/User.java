package app.iVoteHub.domain;

public abstract class User {

	/*Id*/
	public abstract int getId();
	
	public abstract void setId(int id);
	
	/*Username*/
	public abstract String getUsername();
	
	public abstract void setUsername(String username);
	
	/*Password*/
	public abstract String getPassword();
	
	public abstract void setPassword(String password);
	
	/*Role*/
	public abstract String getRole();
	
	public abstract void setRole(String role);
	
}
