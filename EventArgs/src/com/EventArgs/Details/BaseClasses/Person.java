package com.EventArgs.Details.BaseClasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This class contains those details that are required for people playing different roles
 * such as shop owners, venue managers and even the users
 * @author Sunaina
 *
 */

public class Person extends Details
{
	protected String firstName = null;
	protected String lastName = null;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	protected String dateOfBirth = null;
	
	protected LocalDate DOB = null;
	protected String uniqueWord;		//pwd
	private String aadharNo = null;
	
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
		System.out.println("The firstname is set to :" + this.firstName);
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
		System.out.println("The lastname is set to : " +this.lastName);
	}
	
	public LocalDate getDOB() 
	{
		return DOB;
	}
	public void setDOB(String dateOfBirth) 
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		this.DOB = LocalDate.parse(dateOfBirth, date);
//		this.DOB = DOB;
		System.out.println("Date is set to : " + this.DOB);
	}
	
	public String getDateOfBirth() 
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
		setDOB(dateOfBirth);
	}
	
	public String getUniqueWord() 
	{
		return uniqueWord;
	}
	public void setUniqueWord(String uniqueWord) 
	{
		this.uniqueWord = uniqueWord;
		System.out.println("Password is set to :"+ this.uniqueWord);
	}
	
	public String getAadharNo() 
	{
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) 
	{
		this.aadharNo = aadharNo;
	}
	
}
