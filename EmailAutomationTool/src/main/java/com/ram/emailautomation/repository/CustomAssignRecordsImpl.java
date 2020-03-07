package com.ram.emailautomation.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ram.emailautomation.model.InnetDTO;

@Repository
public class CustomAssignRecordsImpl implements CustomAssignRecords
{
	@Autowired
	private JdbcTemplate template;
	public List<InnetDTO> assignRecords(String location, int limit)
	{
		List<InnetDTO> list=null;
		
		list=template.query("select * from innet where Location=? order by Company limit ?",new Object[]
				  {location,limit}, new InnetMapper());
		
		return list;
	}
}
