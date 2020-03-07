package com.ram.emailautomation.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.UserDTO;

@Service
public class DBInit implements CommandLineRunner
{
	private UserRepository userRepository;
	
	public DBInit(UserRepository userRepository) 
	{
		this.userRepository=userRepository;
	}

	public void run(String... args) throws Exception
	{
		UserDTO user=new UserDTO("Kevin",new BCryptPasswordEncoder().encode("Kevin"),"Thomos","kevin.thomos@oracle.com","USER","");
		UserDTO admin=new UserDTO("Ramanji",new BCryptPasswordEncoder().encode("Ram"),"Esther","Ramanji-esther@mcbenz.com","ADMIN","ACCESS_TEST1");
		UserDTO manager=new UserDTO("Shreya",new BCryptPasswordEncoder().encode("Shreya"),"Moses","Shreya_moses@Microsoft.com","MANAGER","ACCESS_TEST2");
		
		List<UserDTO> users= new ArrayList<UserDTO>();
		users.add(user);
		users.add(admin);
		users.add(manager);
		//this.userRepository.saveAll(users);
		
	}
	

}
