package com.EventArgs.Model.Request;

public class UserCheckEmailExistenceRequest
{
	private String message;
	private String email;
	
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
}
