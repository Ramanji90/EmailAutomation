package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.service.ViewAllAssignedRecordsService;

@Controller
@RequestMapping("admin")
public class ViewAllAssignedRecordsController
{
	@Autowired
	  private ViewAllAssignedRecordsService service;
	  
	  @GetMapping("view/all/assigned/records")
	  public ModelAndView viewAllAssignedRecords(@RequestParam("user") String user)
	  {
		  if(user!="Select User")
		  {
		  List<InnetDTO> list=service.viewAllAssignedRecords(user);
		  if(list!=null)
		  {
			  return new ModelAndView("admin/view-all-records","list",list);
		  }
		  else
		  {
			  return new ModelAndView("admin/view-all-records","list",list);
		  }
		  }
		  else
		  {
			  return new ModelAndView("error/error","error","Please select User");
		  }
	  }
}
