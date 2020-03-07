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
@Table(name="email")
public class EmailDTO 
{
	@Id
	@GeneratedValue(generator="emailIndex",strategy=GenerationType.AUTO)
	@Column(name="ID")
	private long id;
	@Column(name="Date")
	private Date date;
	@Column(name="Company")
	private String company;
	@Column(name="First_Name")
	private String firstName;
	@Column(name="Contact_Name")
	private String contactName;
	@Column(name="Email_Id",nullable=true)
	private String email;
	@Column(name="Validation")
	private String validation;
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
	@Column(name="Mailer_Status")
	private String mailerStatus;
	@Column(name="Course")
	private String course;
	
	public EmailDTO()
	{
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
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

	public String getMailerStatus() {
		return mailerStatus;
	}

	public void setMailerStatus(String mailerStatus) {
		this.mailerStatus = mailerStatus;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "EmailDTO [id=" + id + ", date=" + date + ", company=" + company + ", firstName=" + firstName
				+ ", contactName=" + contactName + ", email=" + email + ", validation=" + validation + ", designation="
				+ designation + ", location=" + location + ", industry=" + industry + ", createdBy=" + createdBy
				+ ", fileName=" + fileName + ", mailerStatus=" + mailerStatus + ", course=" + course + "]";
	}
	
	
	
	

}