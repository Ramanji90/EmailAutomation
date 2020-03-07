package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ram.emailautomation.model.UserDTO;
import com.ram.emailautomation.service.ViewAllUsersService;

@Controller
@RequestMapping("admin")
public class ViewAllUsersController
{
	 @Autowired
	   private ViewAllUsersService service;
	   
	   @GetMapping("view/all/users")
	   public ModelAndView viewAllUsers()
	   {
		   List<UserDTO> users=service.viewAllUsers();
		   if(users!=null)
		   {
			   return new ModelAndView("admin/view-all-employees","list",users);
		   }
		   else
		   {
			   return new ModelAndView("error/error","error","No Users Found");
		   }
	   }

}
