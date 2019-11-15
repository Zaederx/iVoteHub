package app.iVoteHub.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import app.iVoteHub.domain.User;
import app.iVoteHub.repositories.GeneralUserRepository;
@Service
public class GeneralUserDetailsService implements UserDetailsService {
	
	@Autowired
	private GeneralUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("At userDetailsService");
		User u = userRepo.findByUsername(username);

		String password = "";
		String role = "";
		password =  u.getPassword();
		role = u.getRole();
		
	
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		ArrayList<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		
		authority.add(new SimpleGrantedAuthority(role));
		System.out.println("New user: " + role);
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
