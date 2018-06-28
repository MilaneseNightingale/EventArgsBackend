package com.EventArgs.Model.Request;

public class MyEventsRequest
{
	private long userID;
	private String message;
	
	public long getUserID() 
	{
		return userID;
	}
	public void setUserID(long userID) 
	{
		this.userID = userID;
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
