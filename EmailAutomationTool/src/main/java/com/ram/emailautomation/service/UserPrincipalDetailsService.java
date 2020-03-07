package com.ram.emailautomation.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.UserDTO;
import com.ram.emailautomation.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService 
{
	private UserRepository userRepository;
	
	public UserPrincipalDetailsService(UserRepository userRepository)
	{
		this.userRepository=userRepository;
	}

	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserDTO userDB=this.userRepository.findByUsername(username);
		
		return new UserPrincipal(userDB);
	}
	

}
