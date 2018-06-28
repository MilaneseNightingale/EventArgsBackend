package com.EventArgs.Model.POJOS;

import java.util.ArrayList;

public class MainEventType 
{
	private String mainEventTypeName ;
	private String mainEventTypeImageLink;
	private ArrayList<String> subEventTypes;
	
	public String getMainEventTypeName() 
	{
		return mainEventTypeName;
	}
	public void setMainEventTypeName(String mainEventTypeName)
	{
		this.mainEventTypeName = mainEventTypeName;
	}
	
	public String getMainEventTypeImageLink() 
	{
		return mainEventTypeImageLink;
	}
	public void setMainEventTypeImageLink(String mainEventTypeImageLink) 
	{
		this.mainEventTypeImageLink = mainEventTypeImageLink;
	}
	
	public ArrayList<String> getSubEventTypes()
	{
		return subEventTypes;
	}
	public void setSubEventTypes(ArrayList<String> subEventTypes) 
	{
		this.subEventTypes = subEventTypes;
	}
	
}
