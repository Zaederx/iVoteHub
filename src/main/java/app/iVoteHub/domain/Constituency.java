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

@Entity
public class Constituency {

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
	
	public Constituency () {

	}

	public Constituency (String name) {
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
	
	public int getCount() {
		return votes.size();
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
