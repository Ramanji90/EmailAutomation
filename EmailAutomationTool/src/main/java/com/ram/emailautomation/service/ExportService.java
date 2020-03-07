package com.ram.emailautomation.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.model.EmailDTO;
import com.ram.emailautomation.repository.ExportRepository;

@Service
public class ExportService 
{
	@Autowired
	   private ExportRepository repository;
	
	   public File export(String location,String fromDate,String toDate)
	   {  
		   File file=new File("E://"+location+".xlsx");
		   List<EmailDTO> list=repository.export(location, fromDate, toDate);
		   if(list!=null)
		   {
			   
		   
			   XSSFWorkbook workbook=new XSSFWorkbook();
			   XSSFSheet sheet=workbook.createSheet("first Sheet");
			   for(int i=0;i<list.size();i++)
			   {
			      Row currentRow=sheet.createRow(i);
			      currentRow.createCell(0).setCellValue(list.get(i).getCompany());
			      currentRow.createCell(1).setCellValue(list.get(i).getContactName());
			      currentRow.createCell(2).setCellValue(list.get(i).getFirstName());
			      currentRow.createCell(3).setCellValue(list.get(i).getEmail());
			      currentRow.createCell(4).setCellValue(list.get(i).getDesignation());
			      currentRow.createCell(5).setCellValue(list.get(i).getLocation());
			      currentRow.createCell(6).setCellValue(list.get(i).getIndustry());
			      currentRow.createCell(7).setCellValue(list.get(i).getCreatedBy());
			      currentRow.createCell(8).setCellValue(list.get(i).getMailerStatus());
			      
			      
			   }
			   try {
				workbook.write(new FileOutputStream(file));
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
		   }
			   
		   else
		   {
			   return null;
		   }
		   System.out.println("done");
		   return file;
	   }
}
