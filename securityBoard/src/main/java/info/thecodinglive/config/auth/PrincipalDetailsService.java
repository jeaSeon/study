package info.thecodinglive.config.auth;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import info.thecodinglive.model.Users;
import info.thecodinglive.repository.SecurityUsersRepository;
import info.thecodinglive.repository.SecurityUsersRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	@Autowired
	SecurityUsersRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user=userRepository.findByUsername(username);
		if(user!=null) {
			return new PrincipalDetails(user);
		}
		return null;
	}

}
