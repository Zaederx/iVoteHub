package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.ElectionCommission;

public interface ElectionCommissionRepository extends CrudRepository<ElectionCommission, Integer>{

 ElectionCommission findByUsername(String username);
	
}
