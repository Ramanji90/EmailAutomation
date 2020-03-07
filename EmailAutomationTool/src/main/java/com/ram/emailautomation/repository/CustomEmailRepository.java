package com.ram.emailautomation.repository;

import com.ram.emailautomation.model.EmailDTO;

public interface CustomEmailRepository 
{
	public EmailDTO fetchByCompany(String company);
}
