package com.ram.emailautomation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ram.emailautomation.model.EmailDTO;

@Repository
public class CustomExportRepositoryImpl  implements  CustomExportRepository
{
	@Autowired
	JdbcTemplate template;
	public List<EmailDTO> export(String location,String fromDate, String toDate)
    {
    		List<EmailDTO> list=null;
    	try 
    	{
    			list=template.query("select * from email where Location=? and Date>=? and Date <= date_add(?, INTERVAL 1 DAY)",new Object[] {location,fromDate,toDate}, new EmailMapper());
    	
    	if(list==null)
    	{
    		throw new NullPointerException("No Records found");
    	}
    	}
    	catch(NullPointerException ne)
    	{
    		ne.printStackTrace();
    	}
    	return list;
    }
}
