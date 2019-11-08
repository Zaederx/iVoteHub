package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * @author Zachary Ishmael
 * 
 * Entity class used to represent Voters.
 *
 */
@Entity
public class Voter extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;// could be email - will have to consider 
	//- elder folks often share email?? - not good for voting system if emails used as unique username
	@Column
	private String fullname;
	@Column
	private String constituency;
	@Column
	private String password;
	@Column
	private int SNI;// Shangri-La National Insurance number
	@Column
	private String role;
	@Column
	private boolean voted;


	/**
	 * 
	 * @param id
	 * @param fullname
	 * @param password
	 * @param SNI - Shangri-La National Insurance number
	 */
	public Voter (int id, String fullname, String password, int SNI) {
		this.id = id;
		this.fullname = fullname;
		this.password = password;
		this.SNI = SNI;
		this.role = "Role_Voter";
	}

	/*Id*/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	/*Fullname*/
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	
	/*Constituency*/
	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	
	/*Password*/
	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Override
	public String getRole() {
		
		return role;
	}

	@Override
	public String getUsername() {
		return username; // could be email
	}
	
}
