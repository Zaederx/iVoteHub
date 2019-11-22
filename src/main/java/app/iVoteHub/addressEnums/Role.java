package app.iVoteHub.addressEnums;

public enum Role {
	VOTER ("ROLE_VOTER"),
	ELECTIONCOMMISSION("ROLE_ELECTIONCOMMISSION");
	
	private String role;
	Role (String role) {
	this.role = role;	
	}
	public String role() {
		return role;
	}
}