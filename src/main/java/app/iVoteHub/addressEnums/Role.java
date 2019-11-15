package app.iVoteHub.addressEnums;

public enum Role {
	VOTER ("ROLE_VOTER"),
	CANADIDATE("ROLE_CANDIDATE");
	
	private String role;
	Role (String role) {
	this.role = role;	
	}
	public String role() {
		return role;
	}
}