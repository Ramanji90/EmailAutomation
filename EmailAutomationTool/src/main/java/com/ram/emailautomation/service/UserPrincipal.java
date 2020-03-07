package com.ram.emailautomation.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ram.emailautomation.model.UserDTO;

public class UserPrincipal implements UserDetails
{
    private UserDTO userDTO;
    
    public UserPrincipal(UserDTO userDTO)
    {
		this.userDTO=userDTO;
	}
	public Collection<? extends GrantedAuthority> getAuthorities() 
	{
		List<GrantedAuthority> authorities= new ArrayList();
		
		//Extract List of Permissions (names)
		
		List<String> permissions=this.userDTO.getPermissionsList();
		for(String permission:permissions)
		{
			GrantedAuthority authority=new SimpleGrantedAuthority(permission);
			authorities.add(authority);
		}
		
		//Extract List of roles (ROLE_name)
		List<String> roles=this.userDTO.getRolesList();
		for(String role:roles)
		{
			GrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+role);	
			authorities.add(authority);
		}
		return authorities;
	}

	public String getPassword() 
	{
		
		return this.userDTO.getPassword();
	}

	public String getUsername()
	{
		return this.userDTO.getUsername();
	}

	public boolean isAccountNonExpired()
	{
		return true;
	}

	public boolean isAccountNonLocked()
	{
		return true;
	}

	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	public boolean isEnabled()
	{
		return this.userDTO.getActive()==1;
	}

}
