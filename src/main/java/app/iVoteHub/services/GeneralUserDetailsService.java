package app.iVoteHub.services;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.iVoteHub.domain.Candidate;
import app.iVoteHub.domain.User;
import app.iVoteHub.domain.Voter;
import app.iVoteHub.repositories.GeneralUserRepository;
@Service
public class GeneralUserDetailsService implements UserDetailsService {
	
	@Autowired
	private GeneralUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("At userDetailsService");
		User u= userRepo.findByUsername(username);
//		if ((User)u instanceof Voter) {
//			
//		}

		String password = "";
		String role = "";
		password =  u.getPassword();
		role = u.getRole();
		
//		if ((Voter)u instanceof Voter ) {
//			password = ((Voter) u).getPassword();
//			role = ((Voter) u).getRole();
//		}
//		if ((Candidate)u instanceof Candidate ) {
//			password = ((Candidate) u).getPassword();
//			role = ((Candidate) u).getRole();
//		}
		
		
	
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		ArrayList<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		
		authority.add(new SimpleGrantedAuthority(role));
		System.out.println("New" + role + "given access.");
		return new org.springframework.security.core.userdetails.
				User(username,
					password,
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					authority
					);
	}

	

}
