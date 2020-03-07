package com.ram.emailautomation.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.UpdateAssignRecordsDTO;
import com.ram.emailautomation.repository.UpdateAssignRecordsRepository;

@Service
public class UpdateAssignRecordsService 
{
	@Autowired
	   private UpdateAssignRecordsRepository repository;

	public boolean updateAssignRecords(UpdateAssignRecordsDTO updateDTO)
	{
		boolean status=false;
		int length=updateDTO.getIds().length;
		try
		{
			int counter=0;
			for(long id:updateDTO.getIds())
			{
				int affected=repository.updateAssignRecords(id,updateDTO.getUser(),new Date());
				if(affected !=0)
				{
					counter+=1;
				}
			}
			if(length==counter)
				status=true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return status;
	}
}
