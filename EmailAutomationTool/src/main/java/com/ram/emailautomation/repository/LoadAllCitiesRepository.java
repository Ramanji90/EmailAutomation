package com.ram.emailautomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ram.emailautomation.model.EmailDTO;

public interface LoadAllCitiesRepository extends JpaRepository<EmailDTO, Long> 
{

	@Query("select distinct e.location from EmailDTO e")
	List<String> loadAllCities();

}
