package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/*Constituency Name*/
	@Column
	private String name;
	
	@OneToMany
	private List<Candidate> candidates;
	
	/*must be mappedBy id - too allow Vote Entity id to assign vote to constituencies
	 * Doesn't work without it */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "id")
	private List<Vote> votes;
	
	@Column
	private Integer count;
	
	public Party () {

	}

	public Party (String name) {
		this.name = name;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public void addVote(Vote vote) {
		this.votes.add(vote);
	}
	
	public void count () {
		count = votes.size();
	}
	@Transactional
	public int getCount() {
		setCount();
		if (count == null) {return 0;}
		return count;
	}
	@Transactional
	public void setCount() {
		this.count = votes.size();
	}
}
