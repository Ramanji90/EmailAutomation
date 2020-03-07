package com.ram.emailautomation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.PersistenceException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.AutoCreationReport;
import com.ram.emailautomation.model.EmailDTO;
import com.ram.emailautomation.repository.MergeRepository;

@Service
public class MergeService 
{
	@Autowired
	private MergeRepository repository;
	
	
	public AutoCreationReport insertWithoutAutoCreation(String fileName, String course) 
	{
		AutoCreationReport report= new AutoCreationReport();
		long insertions=0L;
		long duplicates=0L;
		File file = new File(fileName);
		

		try {

			FileInputStream excelFile = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet datatypeSheet = workbook.getSheetAt(0);
			Iterator<Row> iterator = datatypeSheet.iterator();
			
			while (iterator.hasNext()) {
				EmailDTO dto = new EmailDTO();
				Row currentRow = iterator.next();
				if (currentRow.getRowNum() != 0) {
					try
					{
						dto.setCompany(currentRow.getCell(0).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setCompany("");
					}
					try
					{
						dto.setContactName(currentRow.getCell(1).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setContactName("");
					}
					try
					{
						dto.setFirstName(currentRow.getCell(2).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setFirstName("");
					}
					try
					{
						dto.setEmail(currentRow.getCell(3).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setEmail("");
					}
					try
					{
						dto.setDesignation(currentRow.getCell(4).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setDesignation("");
					}
					try
					{
						dto.setCourse(currentRow.getCell(5).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setCourse("");
					}
					try
					{
						dto.setLocation(currentRow.getCell(6).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setLocation("");
					}
					try
					{
						dto.setIndustry(currentRow.getCell(7).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setIndustry("");
					}
					try
					{
						dto.setCreatedBy(currentRow.getCell(8).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setCreatedBy("");
					}
					try
					{
						dto.setMailerStatus(currentRow.getCell(9).getStringCellValue());
					}
					catch(NullPointerException e)
					{
						dto.setMailerStatus("");
					}
					
					dto.setDate(new Date());
					dto.setFileName(file.getName());
					dto.setValidation("g");
					EmailDTO dtoDB=null;
					try
					{
					dtoDB= repository.save(dto);
					}
					catch(Exception e)
					{
						e.printStackTrace();
						duplicates+=1;
					}
					if(dtoDB!=null)
					insertions+=1;
					
					//if(emailDB!=0)
					//insertions+=1;

					// getCellTypeEnum shown as deprecated for version 3.15 //getCellTypeEnum ill
					// be renamed to getCellType starting from version 4.0
				}

			}
			workbook.close();
			
		}
		
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
			System.out.println("FileNotFoundException");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			System.out.println("IOException");
		}

		 report.setCreations(0L);
		 report.setInsertions(insertions);
		 report.setDuplicates(duplicates);
		 return report;
		 
	}
}
