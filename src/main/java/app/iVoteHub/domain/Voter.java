package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
/**
 * 
 * @author Zachary Ishmael
 * 
 * Entity class used to represent Voters.
 *
 */
@Entity
public class Voter extends User{
	

	@Column
	private int id;
	@Column
	protected String username;
	@Column
	protected String name;
	@Column
	protected String password;
	@Column 
	protected String role;
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


	/**
	 * 
	 * @param id
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
