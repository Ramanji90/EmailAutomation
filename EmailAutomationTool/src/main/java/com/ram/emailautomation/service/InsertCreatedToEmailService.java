package com.ram.emailautomation.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.EmailDTO;
import com.ram.emailautomation.repository.ImportRepository;
import com.ram.emailautomation.repository.InsertCreatedToEmailRepository;

@Service
public class InsertCreatedToEmailService 
{
	@Autowired
	private InsertCreatedToEmailRepository repository;
	
	@Autowired
	private ImportRepository innetRepo;

	public EmailDTO insertCreatedEmail(EmailDTO email) throws Exception
	{
		email.setDate(new Date());
		email.setMailerStatus("UN");
		String[] str=email.getContactName().split(" ");
		if(str.length>1)
		email.setFirstName(str[0]);
		EmailDTO emailDB=null;
		try {
		emailDB=repository.save(email);
		if(emailDB!=null)
		{
			innetRepo.deleteById(email.getId());
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			throw new Exception("Record already in DB");
		}
		
		return emailDB;
	}
	

}
