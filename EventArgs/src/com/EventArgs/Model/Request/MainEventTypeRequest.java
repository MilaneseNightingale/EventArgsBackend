package com.EventArgs.Model.Request;

public class MainEventTypeRequest
{
	private String message;
		
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
		System.out.println(message);
	}
}
