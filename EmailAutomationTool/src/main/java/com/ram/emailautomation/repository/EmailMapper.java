package com.ram.emailautomation.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ram.emailautomation.model.EmailDTO;

public class EmailMapper implements RowMapper<EmailDTO> {

	public EmailDTO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		EmailDTO dto=new EmailDTO();
		dto.setContactName(rs.getString(3));
		dto.setId(rs.getLong(1));
		dto.setCompany(rs.getString(2));
		dto.setCourse(rs.getString(4));
		dto.setCreatedBy(rs.getString(5));
		dto.setDate(rs.getDate(6));
		dto.setDesignation(rs.getString(7));
		dto.setEmail(rs.getString(8));
		dto.setFileName(rs.getString(9));
		dto.setFirstName(rs.getString(10));
		dto.setIndustry(rs.getString(11));
		dto.setLocation(rs.getString(12));
		dto.setMailerStatus(rs.getString(13));
		dto.setValidation(rs.getString(14));
		return dto;
	}

}
