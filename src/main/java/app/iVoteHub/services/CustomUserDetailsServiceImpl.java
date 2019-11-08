package app.iVoteHub.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import app.iVoteHub.repositories.CandidateRepository;
import app.iVoteHub.repositories.VoterRepository;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

	@Autowired
	private VoterRepository vRepo;
	
	@Autowired 
	private CandidateRepository cRepo;
	
	@Override
	public UserDetails loadUserByUsernameAndUsertype(String username, String usertype)
			throws UsernameNotFoundException {
		boolean enabled = true;
		boolean accountNotExpired = true;
		boolean credentialsNotExpired = true;
		boolean accountNotLocked = true;
		app.iVoteHub.domain.User user = null;
		switch (usertype) {
		case "VOTER":
			user = vRepo.findByUsername(username);
			
			break;
		
		case "CANDIDATE":
			
			user = cRepo.findByUsername(username);
			
			break;
			
			default: throw new UsernameNotFoundException("No existing role.");
		}
		
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		
		authority.add(new SimpleGrantedAuthority(user.getRole()));

		
		return new User(
				usertype+":"+user.getUsername(),
				user.getPassword(),
				enabled,
				accountNotExpired,
				credentialsNotExpired,
				accountNotLocked,
				authority
				);
	}


	

}
