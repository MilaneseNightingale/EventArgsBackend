package com.EventArgs.Model.Response;

public class RegisterResponse
{
	private long userID;
	private String status;
	private String message;
	
	public long getUserID()
	{
		return userID;
	}
	public void setUserID(long userID) 
	{
		this.userID = userID;
	}
	
	public String getStatus()
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
	
	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
}
