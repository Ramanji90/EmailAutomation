package com.ram.emailautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.emailautomation.model.InnetDTO;

public interface ImportRepository extends JpaRepository<InnetDTO, Long>{

}
