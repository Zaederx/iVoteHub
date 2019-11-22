package app.iVoteHub.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Candidate;

public interface CandidateRepository extends CrudRepository<Candidate, Integer>{
	
	
	public Candidate findByName(String name);
	
	public Candidate findById (int id);
}
