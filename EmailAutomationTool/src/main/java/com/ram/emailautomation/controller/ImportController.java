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

import com.ram.emailautomation.model.ImportReport;
import com.ram.emailautomation.service.ImportService;

@Controller
@RequestMapping
public class ImportController
{
	@Autowired
	private ImportService service;
	@RequestMapping(value="/import",method=RequestMethod.POST)
	  public ModelAndView importInnet(@RequestParam("file") MultipartFile file, Model model)
	  {
			try {
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
				model.addAttribute("message", "Success ("+file.getOriginalFilename()+")");
				System.out.println(file.getOriginalFilename());
			    ImportReport report=service.importInnet(serverFilePath);
			    if(report!=null)
			    {
			    	return new ModelAndView("admin/import","report",report);
			    }
			   } 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return new ModelAndView("error/error","error","Failed to insert");
	  }
}
