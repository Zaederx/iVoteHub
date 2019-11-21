package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Party;
import app.iVoteHub.domain.Vote;

public interface VoteRepository extends CrudRepository<Vote, Integer> {

	Vote getVotesByParty(Party party);
	
	
	
}
