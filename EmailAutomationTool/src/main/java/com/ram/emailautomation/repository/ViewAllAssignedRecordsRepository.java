package com.ram.emailautomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.emailautomation.model.InnetDTO;

public interface ViewAllAssignedRecordsRepository extends JpaRepository<InnetDTO, Long> {

	List<InnetDTO> findByCreatedBy(String user);

}
