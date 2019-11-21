package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vote> votes;
	
	/*The Constituency of the candidate*/
	@ManyToOne
	private Constituency constituency; 
	
	/*Party of the candidate*/
	@ManyToOne(optional = true)
	private Party party;
	
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
	public Candidate (String name) {
		this.name = name;
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


	@Transactional
	public void addVote(Vote vote) {
		votes.add(vote);
	}
	
	@Transactional
	public void addVote (String email) {
		votes.add(new Vote(this,this.party,email));
	}
	
	@Transactional
	public int getCount() {
		setCount();
		if (count == null) {return 0;}//TODO remove if not found to be necessary
		return count;
	}
	
	public void setCount() {
		this.count = votes.size(); //TODO - Change to check for zero and save to db - if neccessary to display result size;
	}

}
