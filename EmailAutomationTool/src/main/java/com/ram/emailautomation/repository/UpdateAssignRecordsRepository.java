package com.ram.emailautomation.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ram.emailautomation.model.InnetDTO;

public interface UpdateAssignRecordsRepository extends JpaRepository<InnetDTO, Long> {

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("update InnetDTO I set I.createdBy=:user,I.date=:date where I.id=:id")
	int updateAssignRecords(@Param("id") long id,@Param("user") String user,@Param("date") Date date);

}
