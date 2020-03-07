package com.ram.emailautomation.repository;

import java.util.List;

import com.ram.emailautomation.model.EmailDTO;

public interface CustomExportRepository
{
	public List<EmailDTO> export(String location,String fromDate, String toDate);
}
