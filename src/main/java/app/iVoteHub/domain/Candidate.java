package app.iVoteHub.domain;

public class Candidate {

	private int id;
	
	private String name;
	
	private String username;
	
	private String role;
	
	
	/**
	 * @param name
	 * @param username
	 * @param role
	 */
	public Candidate (String name, String username, String role) {
		this.name = name;
		this.username = username;
		this.role = "Role_ElectionCommission";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
}
