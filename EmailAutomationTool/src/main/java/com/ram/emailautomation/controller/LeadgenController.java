package com.ram.emailautomation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("leadgen")
public class LeadgenController
{
   @GetMapping("creation/panel")
   public String index()
   {
	   return "leadgen/creation-panel";
   }
}
