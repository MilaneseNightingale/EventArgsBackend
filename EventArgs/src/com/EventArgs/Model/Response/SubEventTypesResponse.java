package com.EventArgs.Model.Response;

import java.util.ArrayList;

public class SubEventTypesResponse
{
	private String message;
	private ArrayList<String> listOfEvents;
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public ArrayList<String> getListOfEvents() 
	{
		return listOfEvents;
	}
	public void setListOfEvents(ArrayList<String> listOfEvents) 
	{
		this.listOfEvents = listOfEvents;
	}

}
