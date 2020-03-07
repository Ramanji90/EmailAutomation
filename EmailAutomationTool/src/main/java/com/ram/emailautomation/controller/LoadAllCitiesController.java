package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.emailautomation.service.LoadAllCitiesService;

@RestController
@RequestMapping("admin")
public class LoadAllCitiesController 
{
  @Autowired
  private LoadAllCitiesService service;
  
  @GetMapping("loadallcities")
  public ResponseEntity<List<String>> loadAllCities()
  {
	  List<String> list=service.loadAllCities();
	  if(list!=null)
	  {
	    return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	  }
	  else
	  {
		  return new ResponseEntity<List<String>>(HttpStatus.NO_CONTENT);
	  }
  }
}
