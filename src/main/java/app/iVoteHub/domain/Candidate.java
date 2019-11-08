package app.iVoteHub.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * 
 * Entity class that represents Candidates in data persistence.<br>
 * An extension the {@link app.iVote.domain.User} class.
 * Stores relevant candidate information.
 * @author Zachary Ishmael
 */
@Entity
public class Candidate extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String role;
	@Column
	private String constituency;
	@Column
	private String party;
	@Column
	private int votes;
	
	
	/**
	 * @param name
	 * @param username
	 * @param role
	 */
	public Candidate (String name, String username) {
		this.name = name;
		this.username = username;
		this.role = "Role_Candidate";
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
