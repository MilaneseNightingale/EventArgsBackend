package com.EventArgs.Model.Response;

import java.util.ArrayList;

import com.EventArgs.Model.POJOS.EventTypesSearchResults;

public class SearchForEventTypesResponse 
{
	private long userID;
	private ArrayList<EventTypesSearchResults> eventTypes;
	private String message;
	
	public long getUserID() 
	{
		return userID;
	}
	public void setUserID(long userID)
	{
		this.userID = userID;
	}
	
	public ArrayList<EventTypesSearchResults> getEventTypes() 
	{
		return eventTypes;
	}
	public void setEventTypes(ArrayList<EventTypesSearchResults> eventTypes)
	{
		this.eventTypes = eventTypes;
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
