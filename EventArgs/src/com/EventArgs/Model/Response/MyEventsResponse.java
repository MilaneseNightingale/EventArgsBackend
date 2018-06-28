package com.EventArgs.Model.Response;

import java.util.ArrayList;
import com.EventArgs.Model.POJOS.Events;

public class MyEventsResponse 
{
	private long userID;
	private ArrayList<Events> myEvents;
	private String message;
	
	public long getUserID() 
	{
		return userID;
	}
	public void setUserID(long userID)
	{
		this.userID = userID;
	}
	
	public ArrayList<Events> getMyEvents() 
	{
		return myEvents;
	}
	public void setMyEvents(ArrayList<Events> myEvents) 
	{
		this.myEvents = myEvents;
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
