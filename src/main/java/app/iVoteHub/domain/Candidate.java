package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import app.iVoteHub.addressEnums.Role;

/**
 * 
 * Entity class that represents Candidates in data persistence.<br>
 * An extension the {@link app.iVote.domain.User} class.
 * Stores relevant candidate information.
 * @author Zachary Ishmael
 */
@Entity(name = "Candidate_Table")
//@PrimaryKeyJoinColumn()
//@PrimaryKeyJoinColumn(name = "c_id",referencedColumnName = "id",foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT))
//@OnDelete(action = OnDeleteAction.CASCADE)
public class Candidate extends User{


	@Column
	private String role;
	@Column
	private String constituency;
	@Column
	private String party;
	@Column
	private int votes;
	
	
	/*Default Constrcutor - Explicitly Required  by 
	 * Spring for new Object generation and casting */
	public Candidate() {
		
	}
	
	/**
	 * @param name
	 * @param username
	 * @param role
	 */
	public Candidate (String name, String username) {
		this.name = name;
		this.username = username;
		this.role = Role.CANDIDATE.role();
		this.votes = 0;
	}


	/**
	 * 
	 * @return
	 */
	public String getConstituency() {
		return constituency;
	}

	/**
	 * 
	 * @param constituency
	 */
	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}


	/**
	 * 
	 * @return
	 */
	public String getParty() {
		return party;
	}


	/**
	 * 
	 * @param party
	 */
	public void setParty(String party) {
		this.party = party;
	}

	/**
	 *  Gets candidate votes.
	 * @return number of votes.
	 */
	public int getVotes() {
		return votes;
	}

	/**
	 * Set the number of candidate votes.
	 * @param votes
	 */
	public void setVotes(int votes) {
		this.votes = votes;
	}


	/**
	 * Gets the candidate names.
	 * @return candidate name
	 */
	public String getName() {
		return name;
	}


	/**
	 * Sets the candidate names.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * Gets the candidate Id.
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the candidate Id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the Candidate username.
	 * @return candidate username
	 */
	public String getUsername() {
		return username;
	}


	/**
	 * Sets the candidate username.
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the candidate password.
	 * @return candidate
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the candidate password.
	 * @return candidate password
	 */
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
