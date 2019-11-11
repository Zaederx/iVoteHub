package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.User;

public interface GeneralUserRepository extends CrudRepository< User, Integer>{
	
	public User findByUsername (String username);
}
