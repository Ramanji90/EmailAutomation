package com.ram.emailautomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.emailautomation.model.UserDTO;
import com.ram.emailautomation.repository.UserRepository;

@RestController
@RequestMapping("api/public")
public class PublicRestAPIController 
{
	@Autowired
	private UserRepository repository;
	public PublicRestAPIController()
	{
	}

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }
    
    @GetMapping("allusers")
    public List<UserDTO> allUsers(){
        return repository.findAll();
    }
    
    @GetMapping("principal")
    public String principal(Authentication auth){
             return auth.getAuthorities().toString();
             
    }

}
