package com.EventArgs.Model.POJOS;

public class EventTypesSearchResults
{
	private String data;
	private String whatType;
	private boolean isLastEventType;
	
	public String getData() 
	{
		return data;
	}
	public void setData(String data)
	{
		this.data = data;
	}
	
	public String getWhatType() 
	{
		return whatType;
	}
	public void setWhatType(String whatType)
	{
		this.whatType = whatType;
	}
	
	public boolean isLastEventType() 
	{
		return isLastEventType;
	}
	public void setLastEventType(boolean isLastEventType)
	{
		this.isLastEventType = isLastEventType;
	}
}
