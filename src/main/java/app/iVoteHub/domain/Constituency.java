package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Vote> votes;
	
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
	
	
}
