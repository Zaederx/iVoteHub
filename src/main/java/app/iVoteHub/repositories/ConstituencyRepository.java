package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Constituency;

public interface ConstituencyRepository extends CrudRepository<Constituency, Integer> {

	Constituency findByName(String name);
	Constituency findById(int id);
}
