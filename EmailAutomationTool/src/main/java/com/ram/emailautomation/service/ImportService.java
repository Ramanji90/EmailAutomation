package com.ram.emailautomation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.ImportReport;
import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.repository.ImportRepository;

@Service
public class ImportService
{
	@Autowired
	private ImportRepository repository;

	public ImportReport importInnet(String fileName)
	{
		long count=0L;
		File file=new File(fileName);
		
		try {

            FileInputStream excelFile = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
            XSSFSheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            
            while (iterator.hasNext()) {
            	InnetDTO dto=new InnetDTO();
                Row currentRow = iterator.next();
                if(currentRow.getRowNum()!=0)
                {
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
	                	dto.setDesignation(currentRow.getCell(2).getStringCellValue());
	                }
	                catch(NullPointerException e)
	                {
	                	dto.setDesignation("");
	                }
	                try
	                {
	                	dto.setLocation(currentRow.getCell(3).getStringCellValue());
	                }
	                catch(NullPointerException e)
	                {
	                	dto.setLocation("");
	                }
	                try
	                {
	                	dto.setIndustry(currentRow.getCell(4).getStringCellValue());
	                }
	                catch(NullPointerException e)
	                {
	                	dto.setIndustry("");
	                }
                dto.setDate(new Date());
                dto.setCreatedBy("");
                dto.setCourse("");
                dto.setFileName(file.getName());
                InnetDTO innetDB=repository.save(dto);
                if(innetDB!=null)
                {
                	count+=1;
                }
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    
                }   
              }
                
               workbook.close();
            
        }
		catch (FileNotFoundException e)
		{
            e.printStackTrace();
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		ImportReport report=new ImportReport();
		report.setInsertions(count);
		report.setDuplicates(0L);
		return report;
	}
}
