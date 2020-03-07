package com.ram.emailautomation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.emailautomation.model.EmailDTO;
import com.ram.emailautomation.service.InsertCreatedToEmailService;

@RestController
@RequestMapping("leadgen")
public class InsertCreatedToEmailController 
{
	@Autowired
	private InsertCreatedToEmailService service;

	
	@PostMapping("insert/email")
	public ResponseEntity<EmailDTO> insertCreatedEmail(@RequestBody EmailDTO email) throws Exception
	{
		if(email!=null)
		{
			EmailDTO emailDB=null;
			try
			{
			  emailDB=service.insertCreatedEmail(email);
			}
			catch(Exception e)
			{
				throw new Exception("Record already in DB");
			}
			if(emailDB!=null)
			{
				return new ResponseEntity<EmailDTO>(emailDB,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<EmailDTO>(new EmailDTO(),HttpStatus.OK);
			}
			
			
		}
		else
		{
			return new ResponseEntity<EmailDTO>(new EmailDTO(),HttpStatus.OK);
		}
	}
}
