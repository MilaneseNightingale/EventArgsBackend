package com.EventArgs.Model.Request;

public class SearchRequest 
{
	private long userID;
	private String text;
	private String message;
	
	public long getUserID()
	{
		return userID;
	}
	public void setUserID(long userID) 
	{
		this.userID = userID;
	}
	
	public String getText() 
	{
		return text;
	}
	public void setText(String text)
	{
		this.text = text;
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
