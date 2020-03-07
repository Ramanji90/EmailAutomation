package com.ram.emailautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.repository.AssignRecordsRepository;

@Service
public class AssignRecordsService
{
	 @Autowired
     private AssignRecordsRepository repository;
	 
	public List<InnetDTO> assignRecords(String location, int limit) 
	{
        List<InnetDTO> list=repository.assignRecords(location,limit);
        if(list!=null)
        {
        	return list;
        }
		return list;
	}
}
