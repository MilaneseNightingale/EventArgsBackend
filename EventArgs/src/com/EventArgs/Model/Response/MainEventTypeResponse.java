package com.EventArgs.Model.Response;

import java.util.ArrayList;

import com.EventArgs.Model.POJOS.MainEventType;

public class MainEventTypeResponse 
{
	private ArrayList<MainEventType> mainEventType;

	public ArrayList<MainEventType> getMainEventType() 
	{
		return mainEventType;
	}
	public void setMainEventType(ArrayList<MainEventType> mainEventType) 
	{
		this.mainEventType = mainEventType;
	}
}
