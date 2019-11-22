package app.iVoteHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.Constituency;
import app.iVoteHub.domain.Party;
import app.iVoteHub.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

	List<Vote> getVotesByParty(Party party);
	
//	List<Vote> getVotesByConstituency(Constituency constituency);
	
	List<Vote> getVotesByCandidate(Candidate candidate);
	
}
