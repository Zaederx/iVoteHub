package app.iVoteHub.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

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
	
	@Transient
	private String password2;
	
	@OneToOne(cascade = CascadeType.ALL)
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
		this.sni = sni;
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
	public SNI getSNI() {
		return sni;
	}

	public void setSNI(SNI sni) {
		this.sni = sni;
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	
}
