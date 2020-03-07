package com.ram.emailautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.UserDTO;
import com.ram.emailautomation.repository.ViewAllUsersRepository;

@Service
public class ViewAllUsersService
{
	@Autowired
	private ViewAllUsersRepository repository;

	public List<UserDTO> viewAllUsers()
	{
		
		return repository.findAll();
	}

}
