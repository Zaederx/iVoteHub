package app.iVoteHub.services;

import app.iVoteHub.domain.User;

public interface GeneralUserDetailsInterface {
	
	void save (Class<? extends User> u);
	
	void delete(Class<? extends User> u);
	
	<T extends User>T getUserByUsername(String username);
	
	<T extends User>T getUserById(int id);
	

}
