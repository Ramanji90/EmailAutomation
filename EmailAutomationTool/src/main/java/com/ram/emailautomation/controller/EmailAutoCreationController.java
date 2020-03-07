package com.ram.emailautomation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ram.emailautomation.model.AutoCreationReport;
import com.ram.emailautomation.service.EmailAutoCreationService;

@Controller
@RequestMapping
public class EmailAutoCreationController
{
	@Autowired
	private EmailAutoCreationService service;
	@PostMapping("/emailautocreation")
   public ModelAndView emailAutoCreation(@RequestParam("file") MultipartFile file,Model model,@RequestParam(value="course",required=false) String course)
   {
		try {
			   if(file!=null)
			   {
			//String root=System.getProperty("catalina.home");
			File dir=new File("E:\\"+File.separator+"upload");
			if(!dir.exists())
				dir.mkdir();
			String fileOnServer=dir.getAbsolutePath()+File.separator+file.getOriginalFilename();
				BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(fileOnServer));
				bos.write(file.getBytes());
				bos.flush();
				bos.close();
				String serverFilePath=new File(fileOnServer).getAbsolutePath();
			model.addAttribute("file", file.getOriginalFilename());
			System.out.println(file.getOriginalFilename());
		    AutoCreationReport report=service.emailAutoCreation(serverFilePath,course);
		    if(report!=null)
		    {
		    	model.addAttribute("message", "Success ("+file.getOriginalFilename()+")");
		    	return new ModelAndView("admin/autocreation","report",report);
		    }
		    else
		    {
		    	return new ModelAndView("error/error","error","Failed Auto Email Creation");
		    }
		   } 
			   else
			   {
				   return new ModelAndView("error/error","error","Please select a file");
			   }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new ModelAndView("error/error","error","Failed Auto Email Creation");
   }
}
