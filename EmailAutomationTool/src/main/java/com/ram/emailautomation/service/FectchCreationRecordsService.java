package com.ram.emailautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.repository.FectchCreationRecordsRepository;

@Service
public class FectchCreationRecordsService {

	@Autowired
	private FectchCreationRecordsRepository repository;
	public List<InnetDTO> fectchCreationRecords(String user) 
	{
		List<InnetDTO> list=repository.findByCreatedBy(user);
		
		return list;
	}

}
