package com.ram.emailautomation.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ram.emailautomation.model.EmailDTO;

public class CustomEmailRepositoryImpl implements CustomEmailRepository{

	@Autowired
	private JdbcTemplate template;
	public EmailDTO fetchByCompany(String company) 
	{
		EmailDTO dto=null;
        try
        {
   		    dto= template.queryForObject(
   				"select * from email where company=? and validation='g' and email_id!='' and mailer_status!='B' and location regexp 'Albany, NY|Albuquerque, NM|Arlington, VA|Atlanta, GA|Austin, TX|Baltimore, MD|Baton Rouge, LA|Billings, MT|Birmingham, AL|Boise, ID|Boston, MA|Buffalo, NY|Burlington, VT|Casper, WY|Cedar Rapids, IA|Charleston, SC|Charleston, WV|Charlotte, NC|Cheyenne, WY|Chicago, IL|Cincinnati, OH|Cleveland, OH|Colorado Springs, CO|Columbia, SC|Columbus, OH|Concord, NH|Dallas, TX|Davenport, IA|Dayton, OH|Denver, CO|Des Moines, IA|Detroit, MI|Dover, DE|Eugene, OR|Fresno, CA|Grand Rapids, MI|Greenville, SC|Hartford, CT|Helena and Great Falls, MT|Houston, TX|Huntington, WV|Idaho Falls, ID|Indianapolis, IN|Jacksonville, FL|Jersey City, NJ|Kansas City, MO|Las Vegas, NV|Lexington, KY|Lincoln, NE|Little Rock, AR|Los Angeles, CA|Louisville, KY|Madison|Manchester, NH|Memphis, TN|Miami, FL|Milwaukee, WI|Minneapolis, MN|Montpelier, VT|Nashville, TN|New Orleans, LA|New York, NY|Newark, NJ|Oklahoma City, OK|Omaha, NE|Orange County, CA|Orlando, FL|Philadelphia, PA|Phoenix, AZ|Pittsburgh, PA|Plano, TX|Portland, OR|Quebec, RI|Raleigh, NC|Reno, NV|Richmond, VA|Rochester, NY|Sacramento, CA|Saint Louis, MO|Salt Lake City, UT|San Antonio, TX|San Diego, CA|San Francisco, CA|San Jose, CA|Santa Barbara, CA|Schaumburg, IL|Seattle, WA|Spokane, WA|Springfield, IL|Tallahassee, FL|Tampa, FL|Topeka, KS|Tucson, AZ|Tulsa, OK|Warwick|Washington, DC|Wichita, KS|Wilmington, DE|Worcester, MA|Bengaluru' order by id desc limit 1",
   				new Object[] { company }, new EmailMapper());
   		
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        finally
        {
        	
        }
		return dto;
	}

}
