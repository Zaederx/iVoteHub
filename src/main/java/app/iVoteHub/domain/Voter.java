package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * 
 * @author Zachary Ishmael
 * 
 * Entity class used to represent Voters.
 *
 */
@Entity
//@PrimaryKeyJoinColumn
public class Voter extends User{
	

	@Column
	private String email;
	@Column
	private String constituency;
	@Column
	private int SNI;// Shangri-La National Insurance number
//	@Column
//	private String role;
	@Column
	private boolean voted;

	Voter () {
		
	}

	/**
	 * 
	 * @param fullname
	 * @param password
	 * @param SNI - Shangri-La National Insurance number
	 */
	public Voter (String fullname, String username, String password, int SNI) {
		this.name = fullname;
		this.username = username;
		this.password= password;
		this.SNI = SNI;
		this.role = Role.VOTER.toString();
	}

	
	/*Fullname*/
	public String getName() {
		return name;
	}

	public void setName(String fullname) {
		this.name = fullname;
	}

	/*Email*/
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	/*Constituency*/
	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	/*SNI*/
	public int getSNI() {
		return SNI;
	}

	public void setSNI(int sNI) {
		SNI = sNI;
	}
	
	
	/*Voted*/
	public boolean isVoted() {
		return voted;
	}

	public void setVoted(boolean voted) {
		this.voted = voted;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
