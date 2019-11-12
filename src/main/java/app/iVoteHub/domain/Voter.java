package app.iVoteHub.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * 
 * @author Zachary Ishmael
 * 
 * Entity class used to represent Voters.
 *
 */
@Entity(name="Voter_Table")
@PrimaryKeyJoinColumn(name = "voter_id")
public class Voter extends User{
	

	@Column
	private String email;
	@Column
	private String constituency;
	
	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="sni", updatable = true, insertable = true,foreignKey = @ForeignKey(foreignKeyDefinition = ""))
	private SNI sni;// Shangri-La National Insurance number

	@Column
	private boolean voted;

	Voter () {
		super();
	}

	/**
	 * 
	 * @param fullname
	 * @param password
	 * @param SNI - Shangri-La National Insurance number
	 */
	public Voter (String fullname, String username, String password, SNI sni) {
		super();
		this.name = fullname;
		this.username = username;
		this.password= password;
//		this.sni = sni;
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
//	public SNI getSNI() {
//		return sni;
//	}

//	public void setSNI(int sni) {
//		sni = sni;
//	}
	
	
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
