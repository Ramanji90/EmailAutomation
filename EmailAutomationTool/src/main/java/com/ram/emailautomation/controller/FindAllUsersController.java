package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.emailautomation.service.FindAllUsersService;

@RestController
@RequestMapping("admin")
public class FindAllUsersController 
{
  @Autowired
  private FindAllUsersService service;
  
  @GetMapping("fetch/all/users")
  public ResponseEntity<List<String>> fetchAllUsers()
  {
	  List<String> users=service.fetchAllUsers();
	  if(users!=null)
	  {
		  return new ResponseEntity<List<String>>(users,HttpStatus.OK);
	  }
	  else
	  {
		  return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
	  }
  }
  
}
