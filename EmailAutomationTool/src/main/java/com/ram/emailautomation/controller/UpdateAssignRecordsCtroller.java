package com.ram.emailautomation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.emailautomation.model.UpdateAssignRecordsDTO;
import com.ram.emailautomation.service.UpdateAssignRecordsService;

@RestController
@RequestMapping("admin")
public class UpdateAssignRecordsCtroller 
{
	 @Autowired
	   private UpdateAssignRecordsService service;
	   
	   @PostMapping(value="/update/assign/records")
	   public ResponseEntity<Object> updateAssignRecords(@RequestBody UpdateAssignRecordsDTO updateDTO)
	   {
		   System.out.println(updateDTO);
		   if(updateDTO!=null)
		   {
			   boolean result=service.updateAssignRecords(updateDTO);
			   if(result==true)
			   {  
				   System.out.println("true	");
				   return new ResponseEntity<Object>(true,HttpStatus.OK);
			   }
			   else
			   {
				   return new ResponseEntity<Object>(false,HttpStatus.INTERNAL_SERVER_ERROR);
			   }
			   
		   }
		   else
		   {
			   return new ResponseEntity<Object>("Input is Empty",HttpStatus.NO_CONTENT);
		   }
	   }
}
