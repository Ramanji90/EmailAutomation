package com.ram.emailautomation.repository;

import java.util.List;

import com.ram.emailautomation.model.InnetDTO;

public interface CustomAssignRecords
{
	public List<InnetDTO> assignRecords(String location, int limit);
}
