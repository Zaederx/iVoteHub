package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Voter;

public interface VoterRepository extends CrudRepository<Voter, Integer>{
	
 public Voter findByUsername(String username);
 
 public Voter findById(int id);
 
	
}
