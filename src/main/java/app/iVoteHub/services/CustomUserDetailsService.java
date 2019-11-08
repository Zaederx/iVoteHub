package app.iVoteHub.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface CustomUserDetailsService {

	UserDetails loadUserByUsernameAndUsertype(String username, String usertype) throws UsernameNotFoundException;


}
