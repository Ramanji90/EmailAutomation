package com.ram.emailautomation.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ram.emailautomation.service.ExportService;

@Controller
@RequestMapping("admin")
public class ExportController 
{
	@Autowired
	private ExportService service;
	
	@GetMapping("exportdata")
	public void  export(@RequestParam("location") String location,@RequestParam("fromDate") String fromDate,@RequestParam("toDate") String toDate,HttpServletResponse resp)
	{
		
		File file=service.export(location,fromDate,toDate);
		
		try 
		{    ServletOutputStream os=resp.getOutputStream();
			resp.setHeader("Content-Disposition", "attachment; filename="+file.getName());
			String mimeType = Files.probeContentType(file.toPath());
			resp.setContentType(mimeType);
			resp.setContentLength((int)file.length());
			Files.copy(file.toPath(), os);
			os.flush();
			os.close();
		
		}
		catch (FileNotFoundException e1) 
		{
			
			e1.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		catch (Exception e) 
		{
			//return new ModelAndView("error/error","error",e.getMessage());
		}
		 
		//return new ModelAndView("admin/export","message",file.getName()+": Exported Successfully");
		
		
	}
}
