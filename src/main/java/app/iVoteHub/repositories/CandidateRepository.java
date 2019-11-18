package app.iVoteHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer>{
	
	
	public Candidate findByUsername(String username);
	
	public Candidate findById (int id);
}
