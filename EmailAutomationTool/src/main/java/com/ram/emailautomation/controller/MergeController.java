package com.ram.emailautomation.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ram.emailautomation.model.AutoCreationReport;
import com.ram.emailautomation.service.MergeService;

@Controller
@RequestMapping("admin")
public class MergeController
{
	@Autowired
	private MergeService service;
	
	@RequestMapping(path="/merge",method=RequestMethod.POST)
  public ModelAndView withoutAutoCreation(@RequestParam("file") MultipartFile file, Model model)
  {
		try {
			  if(file!=null)
			  {
			String root=System.getProperty("catalina.home");
			File dir=new File(root+File.separator+"upload");
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
		    System.out.println(new File(file.getOriginalFilename()).getAbsolutePath());
		    System.out.println(serverFilePath);
		    AutoCreationReport report=service.insertWithoutAutoCreation(serverFilePath,"");
		    if(report!=null)
		    {
		    	model.addAttribute("message", "Success ("+file.getOriginalFilename()+")");
		    	return new ModelAndView("admin/merge","report",report);
		    }
		    else
		    {
		    	return new ModelAndView("error/error","error","Failed to Merge");
		    }
		   }
			  else
			  {
				  return new ModelAndView("error/error","error","Please Select a file");
			  }
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return new ModelAndView("error/error","error","Failed to Merge");
  }

}
