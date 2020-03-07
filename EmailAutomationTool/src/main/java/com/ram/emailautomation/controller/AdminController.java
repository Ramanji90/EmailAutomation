package com.ram.emailautomation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminController 
{
	@GetMapping("index")
    public String index(){
        return "admin/index";
    }
	
	@GetMapping("autocreation")
	   public String autoEmailCreation()
	   {
		   return "admin/autocreation";
	   }
	
	@GetMapping("import")
	   public String importEmail()
	   {
		   return "admin/import";
	   }
	
	@GetMapping("export")
	   public String exportEmail()
	   {
		   return "admin/export";
	   }
	
	@GetMapping("assign/records")
	   public String assignRecords()
	   {
		   return "admin/assign-records";
	   }
	
	@GetMapping("add/employee")
	   public String addEmployee()
	   {
		   return "admin/add-employee";
	   }
	
	@GetMapping("merge")
	   public String merge()
	   {
		   return "admin/merge";
	   }
	
	@GetMapping("view/all/employees")
	   public String viewAllEmpoyees()
	   {
		   return "admin/view-all-employees";
	   }
	
	@GetMapping("view/all/records")
	   public String viewAllRecords()
	   {
		   return "admin/view-all-records";
	   }
	
	@GetMapping("report")
	   public String report()
	   {
		   return "admin/report";
	   }
	

}
