package com.ram.emailautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.emailautomation.model.EmailDTO;

public interface EmailAutoCreationRepository  extends JpaRepository<EmailDTO, Long>,CustomEmailRepository
{

}
