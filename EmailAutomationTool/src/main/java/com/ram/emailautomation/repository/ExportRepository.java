package com.ram.emailautomation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.emailautomation.model.EmailDTO;

public interface ExportRepository extends JpaRepository<EmailDTO, Long>, CustomExportRepository {

}
