package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Constituency;
import app.iVoteHub.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

	Vote getVotesByConstituency(Constituency constituency);
	
	
	
}
