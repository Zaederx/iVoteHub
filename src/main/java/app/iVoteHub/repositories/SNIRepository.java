package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.SNI;

public interface SNIRepository extends CrudRepository<SNI, Integer> {

	SNI findBySniCode(String sniCode);

	
	
	
	
}
