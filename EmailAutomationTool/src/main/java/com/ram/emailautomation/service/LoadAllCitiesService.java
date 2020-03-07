package com.ram.emailautomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.emailautomation.repository.LoadAllCitiesRepository;

@Service
public class LoadAllCitiesService
{
  @Autowired
  private LoadAllCitiesRepository repository;
  
  public List<String> loadAllCities()
  {
	  List<String> list=repository.loadAllCities();
	  return list;
  }
}
