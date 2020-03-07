package com.ram.emailautomation.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Innet")
public class InnetDTO 
{
  @Id
  @GeneratedValue(generator="any", strategy=GenerationType.AUTO)
  @Column(name="ID")
  private long id;
  @Column(name="Company")
  private String company;
  @Column(name="Contact_Name")
  private String contactName;
  @Column(name="Designation")
  private String designation;
  @Column(name="Location")
  private String location;
  @Column(name="Industry")
  private String industry;
  @Column(name="Created_By")
  private String createdBy;
  @Column(name="File_Name")
  private String fileName;
  @Column(name="Date")
  private Date date;
  @Column(name="Course")
  private String course;
  
  public InnetDTO()
  {
	
  }

public long getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getCompany() {
	return company;
}

public void setCompany(String company) {
	this.company = company;
}

public String getContactName() {
	return contactName;
}

public void setContactName(String contactName) {
	this.contactName = contactName;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getIndustry() {
	return industry;
}

public void setIndustry(String industry) {
	this.industry = industry;
}

public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getFileName() {
	return fileName;
}

public void setFileName(String fileName) {
	this.fileName = fileName;
}

public String getDate() {
	return new SimpleDateFormat("yyyy-MM-dd")
			.format(date);
}

public void setDate(Date date) {
	this.date = date;
}

public String getCourse() {
	return course;
}

public void setCourse(String course) {
	this.course = course;
}

@Override
public String toString() {
	return "InnetDTO [id=" + id + ", company=" + company + ", contactName=" + contactName + ", designation="
			+ designation + ", location=" + location + ", industry=" + industry + ", createdBy=" + createdBy
			+ ", fileName=" + fileName + ", date=" + date + ", course=" + course + "]";
}

  

}