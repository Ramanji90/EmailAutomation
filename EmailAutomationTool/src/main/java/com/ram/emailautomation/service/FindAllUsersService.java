package com.ram.emailautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.repository.FindAllUsersRepository;

@Service
public class FindAllUsersService 
{
   @Autowired
   private FindAllUsersRepository repository;
	public List<String> fetchAllUsers() 
	{
		return repository.fetchAllUsers();
	}

}
