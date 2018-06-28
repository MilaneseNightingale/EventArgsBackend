package com.EventArgs.Model.Request;

public class SubEventTypesRequest
{
	private String message;
	private String parentEventType;

	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
	public String getParentEventType() 
	{
		return parentEventType;
	}
	public void setParentEventType(String parentEventType)
	{
		this.parentEventType = parentEventType;
	}
	
}
