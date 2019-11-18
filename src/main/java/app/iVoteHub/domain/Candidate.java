package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.transaction.annotation.Transactional;

import app.iVoteHub.addressEnums.Role;

/**
 * 
 * Entity class that represents Candidates in data persistence.<br>
 * An extension the {@link app.iVote.domain.User} class.
 * Stores relevant candidate information.
 * @author Zachary Ishmael
 */
@Entity(name = "Candidate_Table")
public class Candidate extends User{


	@Column
	private String role;

	@Column
	private String party;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vote> votes;
	
	/*The party of the candidate*/
	@ManyToOne
	private Constituency constituency; 
	
	/*Total number of votes*/
	@Column
	private Integer count;
	
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
	}


	/**
	 * 
	 * @return
	 */
	public Constituency getConstituency() {
		return constituency;
	}

	/**
	 * 
	 * @param constituency
	 */
	public void setConstituency(Constituency constituency) {
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
	public List<Vote> getVotes() {
		return votes;
	}

	/**
	 * Set the number of candidate votes.
	 * @param votes
	 */
	public void setVotes(List<Vote> votes) {
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

	@Transactional
	public void addVote(Vote vote) {
		votes.add(vote);
	}
	
	@Transactional
	public void addVote (String email) {
		votes.add(new Vote(this,this.constituency,email));
	}
	
	public int getCount() {
		return votes.size();
	}
	
	public void setCount(int count) {
		this.count = count;
	}

}
