package com.EventArgs.Model.Request;

public class MainDisplayRequest
{
	private long userID;
	private String message;
	private String eventType;
	
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
	
	public String getEventType() 
	{
		return eventType;
	}
	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}
	
}
