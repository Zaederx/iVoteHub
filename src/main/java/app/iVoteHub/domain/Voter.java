package app.iVoteHub.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import app.iVoteHub.addressEnums.Role;
import app.iVoteHub.modelAttributes.VoterRegForm;

/**
 * 
 * @author Zachary Ishmael
 * 
 * Entity class used to represent Voters.
 *
 */
@Entity(name="Voter_Table")
//@PrimaryKeyJoinColumn(name = "voter_id")//for naming primary key in ddl
public class Voter extends User{
	
	@Column(unique = true, nullable = false)
	private String email;
	@Column
	private int candidateId;
	
	@Transient
	private String password2;
	
	@OneToOne
	private SNI sni;// Shangri-LaNational Insurance number

	@Column
	private boolean voted;

	public Voter () {
		this.role = "ROLE_VOTER";
	}

	/**
	 * 
	 * @param fullname
	 * @param password
	 * @param SNI - Shangri-La National Insurance number
	 */
	public Voter (String fullname, String username, String password, SNI sni) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.name = fullname;
		this.username = username;
		this.password = encoder.encode(password);
		this.sni = sni;
		this.role = Role.VOTER.role();
	}

	
	public Voter(VoterRegForm voterForm) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		this.name = voterForm.getName();
		this.username = voterForm.getUsername();
		this.email = voterForm.getEmail();
		this.password = encoder.encode(voterForm.getPassword());
		this.role = Role.VOTER.role();
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
	public int getCandidate() {
		return candidateId;
	}

	public void setCandidateId(int i) {
		this.candidateId = i;
	}

	/*SNI*/
	public SNI getSNI() {
		return sni;
	}

	public void setSNI(SNI sni) {
		this.sni = sni;
	}
	
	
	/*Voted*/
	public boolean getVoted() {
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
