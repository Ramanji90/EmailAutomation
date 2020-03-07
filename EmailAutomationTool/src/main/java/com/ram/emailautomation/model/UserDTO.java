package com.ram.emailautomation.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserDTO 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	private String lastName;
	private String fullName;
	private String email;
	private int active;
	private String roles;
	private String permissions;
	private Date joiningDate;
	
	public UserDTO() 
	{
		
	}

	public UserDTO(String username, String password,String lastName,String email,String roles, String permissions) {
		super();
		this.username = username;
		this.password = password;
		this.active = 1;
		this.roles = roles;
		this.permissions = permissions;
		this.fullName=username+" "+lastName;
		this.lastName=lastName;
		this.email=email;
		this.joiningDate=new Date();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
	public String getRoles() {
		return roles;
	}

	public List<String> getRolesList() {
		if(this.roles.length()>0)
		{
		  return  Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<String>();
	}
	
	public List<String> getPermissionsList() {
		if(this.permissions.length()>0)
		{
		  return  Arrays.asList(this.permissions.split(","));
		}
		return new ArrayList<String>();
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String username,String lastName) {
		this.fullName = username+" "+lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

	public String getJoiningDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(this.joiningDate);
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + ", lastName=" + lastName
				+ ", fullName=" + fullName + ", email=" + email + ", active=" + active + ", roles=" + roles
				+ ", permissions=" + permissions + ", joiningDate=" + joiningDate + "]";
	}

	

	
	
	
	

}
