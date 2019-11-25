package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import app.iVoteHub.addressEnums.Role;
import app.iVoteHub.repositories.VoterRepository;

/**
 * 
 * Entity class that represents Candidates in data persistence.<br>
 * An extension the {@link app.iVote.domain.User} class.
 * Stores relevant candidate information.
 * @author Zachary Ishmael
 */
@Entity(name = "Candidate_Table")
public class Candidate {
	@Transient
	@Autowired
	VoterRepository vRepo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique = true, nullable = false)
	String name;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vote> votes;
	
	/*The Constituency of the candidate*/
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Constituency.class)
	@JoinColumn(name="constituency", referencedColumnName = "id")
	private Constituency constituency; 
	
	/*Party of the candidate*/
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,targetEntity = Party.class)
	private Party party;
	
	/*Total number of votes*/
	@Column
	private Integer count;
	
	/*Default Constrcutor - Explicitly Required  by 
	 * Spring for new Object generation and casting */
	public Candidate() {
		this.count = 0;
	}
	
	/**
	 * @param name
	 * @param username
	 * @param role
	 */
	public Candidate (String name) {
		this.name = name;
		this.count = 0;
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


	public void addVote(Vote vote) {
		votes.add(vote);
	}
	

	public void addVote (String email) {
		Vote vote = new Vote(this,this.party,email);
		
		votes.add(vote);
	}
	

	public int getCount() {
		setCount(votes.size());
		return count;
	}
	
	public void setCount(int count) {
		this.count = count; //TODO - Change to check for zero and save to db - if neccessary to display result size;
	}

	
	/**
	 * @return the party
	 */
	public Party getParty() {
		return party;
	}

	/**
	 * @param party the party to set
	 */
	public void setParty(Party party) {
		this.party = party;
	}

//	/**
//	 * @param count the count to set
//	 */
//	public void setCount(Integer count) {
//		this.count = count;
//	}

}
