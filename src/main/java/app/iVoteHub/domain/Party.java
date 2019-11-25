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
	
	@OneToMany(cascade = CascadeType.REFRESH, mappedBy = "party",targetEntity = Candidate.class )
	private List<Candidate> candidates;
	

	 /* Doesn't work without it */
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "id")
	private List<Vote> votes;
	
	@Transient
	private Integer count;
	
	public Party () {
		this.count = 0;
	}

	public Party (String name) {
		this.name = name;
		this.count = 0;
		
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
		int temp = 0;
		for(Candidate c : candidates) {
			temp+=c.getVotes().size();
		}
		setCount(temp);
		return count;
	}

	
	public void setCount(int count) {
		this.count = count;
	}
}
