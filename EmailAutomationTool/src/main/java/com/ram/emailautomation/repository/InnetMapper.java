package com.ram.emailautomation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ram.emailautomation.model.InnetDTO;

public class InnetMapper implements RowMapper<InnetDTO> 
{

	public InnetDTO mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		InnetDTO dto=new InnetDTO();
		dto.setId(rs.getInt(1));
		dto.setContactName(rs.getString(3));
		dto.setCompany(rs.getString(2));
		dto.setCourse(rs.getString(4));
		dto.setCreatedBy(rs.getString(5));
		dto.setDate(rs.getDate(6));
		dto.setDesignation(rs.getString(7));
		dto.setFileName(rs.getString(8));
		dto.setIndustry(rs.getString(9));
		dto.setLocation(rs.getString(10));
		return dto;
	}

}
