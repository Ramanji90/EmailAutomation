package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.emailautomation.model.InnetDTO;
import com.ram.emailautomation.service.FectchCreationRecordsService;

@RestController
@RequestMapping("leadgen")
public class FectchCreationRecordsController
{
	@Autowired
	  private FectchCreationRecordsService service;
	  
	  @GetMapping("fetchcreation/{user}")
	  public ResponseEntity<List<InnetDTO>> fectchCreationRecords(@PathVariable("user") String user)
	  {
		  List<InnetDTO> list=service.fectchCreationRecords(user);
		  if(list!=null)
		  {
			  return new ResponseEntity<List<InnetDTO>>(list,HttpStatus.OK);
		  }
		  else
		  {
			  return new ResponseEntity<List<InnetDTO>>(HttpStatus.NO_CONTENT);
		  }
	  }
}
