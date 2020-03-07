package com.ram.emailautomation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.ram.emailautomation.service.UserPrincipalDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	private UserPrincipalDetailsService userDetailsService;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception 
	{
		auth
		.authenticationProvider(authenticationProvider());
		
		
	}
	
	private AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/index").permitAll()
		.antMatchers("/console/**").permitAll()
		.antMatchers("/profile/**").authenticated()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/management/**").hasAnyRole("ADMIN","MANAGER")
		.antMatchers("/hr/**").hasRole("HR")
		/*.antMatchers("/api/public/test2").hasRole("MANAGER")
		.antMatchers("/api/public/**").hasRole("ADMIN")*/
		.antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
		.antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
		.antMatchers("/api/public/allusers").hasRole("ADMIN")
		.and()
		.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
		.and()
		.rememberMe().tokenValiditySeconds(2592000).key("mySecrete!");//valid for 30 days
		http.headers().frameOptions().disable();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}
