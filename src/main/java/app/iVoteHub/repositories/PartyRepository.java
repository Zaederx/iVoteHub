package app.iVoteHub.repositories;

import org.springframework.data.repository.CrudRepository;

import app.iVoteHub.domain.Party;

public interface PartyRepository extends CrudRepository<Party, Integer> {

	Party findByName(String name);
	Party findById(int id);
}
