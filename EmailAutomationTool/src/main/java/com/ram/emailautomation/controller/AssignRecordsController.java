package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.service.AssignRecordsService;

@Controller
@RequestMapping("admin")
public class AssignRecordsController 
{
	@Autowired
	private AssignRecordsService service;
	
	@RequestMapping("assignrecords")
	public ModelAndView assignRecords(@RequestParam(value="location",required=false) String location,@RequestParam(value="limit",required=false) int limit)
	{
		if(location!=null && limit!=0)
		{
			List<InnetDTO> list=service.assignRecords(location,limit);
			if(list!=null)
			{
				System.out.println(list.size());
			return new ModelAndView("admin/assign-records","list",list);
			}
			else
			{
			return new ModelAndView("error/error","error","No Records Found");
			}
		}
		else
		{
			return new ModelAndView("error/error","error","Please select City and No Of Records");
		}
		
	}
}
