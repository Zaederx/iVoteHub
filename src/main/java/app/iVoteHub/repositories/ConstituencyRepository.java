package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.Constituency;
import app.iVoteHub.domain.Voter;

public interface ConstituencyRepository extends CrudRepository<Constituency, Integer>{

	Constituency findByName(String name);
	
	Constituency findByCandidate(Candidate candidate);
	
	Constituency findByVoters(Voter voters);
	
}
