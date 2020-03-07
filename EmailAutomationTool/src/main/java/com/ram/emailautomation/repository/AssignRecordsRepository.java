package com.ram.emailautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.emailautomation.model.InnetDTO;

public interface AssignRecordsRepository extends JpaRepository<InnetDTO, Long>,CustomAssignRecords {

}
