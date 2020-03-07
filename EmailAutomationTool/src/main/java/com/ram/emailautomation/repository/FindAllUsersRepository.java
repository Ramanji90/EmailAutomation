package com.ram.emailautomation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ram.emailautomation.model.UserDTO;

public interface FindAllUsersRepository extends JpaRepository<UserDTO, Long> {

	@Query("select distinct u.username from UserDTO u")
	List<String> fetchAllUsers();

}
