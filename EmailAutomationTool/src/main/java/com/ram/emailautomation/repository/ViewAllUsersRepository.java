package com.ram.emailautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.emailautomation.model.UserDTO;

public interface ViewAllUsersRepository extends JpaRepository<UserDTO, Long> {

}
