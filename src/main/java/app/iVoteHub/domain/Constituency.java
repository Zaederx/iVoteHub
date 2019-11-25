package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

/**
 * Entity to persist constituency.
 * @author Zachary Ishmael
 *
 */
@Entity
public class Constituency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "constituency",targetEntity = Candidate.class)
	private List<Candidate> candidate;
	
	@OneToMany
	private List<Voter> voters;
	
	@Transient
	int count;
	
	
	public Constituency () {
		count = 0;
	}

	public Constituency(String name) {
		this.count = 0;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the candidate
	 */
	public List<Candidate> getCandidate() {
		return candidate;
	}

	/**
	 * @param candidate the candidate to set
	 */
	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}

	/**
	 * @return the voters
	 */
	public List<Voter> getVoters() {
		return voters;
	}

	/**
	 * @param voters the voters to set
	 */
	public void setVoters(List<Voter> voters) {
		this.voters = voters;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		int temp = 0;
		for(Candidate c : candidate) {
			temp+=c.getVotes().size();
		}
		setCount(temp);
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
}
