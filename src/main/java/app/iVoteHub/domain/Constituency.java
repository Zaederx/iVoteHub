package app.iVoteHub.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Constituency {
	
	@Column
	private String name;
	
	@OneToMany
	private List<Candidate> candidate;
	
	@OneToMany
	private List<Voter> voters;
	
	

}
