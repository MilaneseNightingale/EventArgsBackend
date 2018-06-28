package com.EventArgs.Details.BaseClasses;

/**
 * This class stores the basic details required by any of the main actors in the use cases
 * @author Sunaina
 *
 */
class Details 
{
	private String phoneNumber = null;
	private String email;
	private String regID = null;
	
	public String getPhoneNumber()
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
		System.out.println("phoneNumber is set to "+this.phoneNumber);
	}
	
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
		System.out.println("email is set to "+this.email);
	}	
	
	public String getRegID()
	{
		return regID;
	}
	public void setRegID(String regID)
	{
		this.regID = regID;
		System.out.println("Regid is set to :" +this.regID);
	}
	
}
