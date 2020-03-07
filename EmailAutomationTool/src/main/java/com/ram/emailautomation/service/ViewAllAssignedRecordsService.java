package com.ram.emailautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.repository.ViewAllAssignedRecordsRepository;

@Service
public class ViewAllAssignedRecordsService 
{

	@Autowired
	private ViewAllAssignedRecordsRepository repository;
	
	public List<InnetDTO> viewAllAssignedRecords(String user) 
	{
		return repository.findByCreatedBy(user);
	}
	

}
