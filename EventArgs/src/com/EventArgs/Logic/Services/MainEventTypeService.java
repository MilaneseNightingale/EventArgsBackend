package com.EventArgs.Logic.Services;

import java.util.ArrayList;

import com.EventArgs.Database.DAO.MainEventTypeDAO;
import com.EventArgs.Model.POJOS.MainEventType;
import com.EventArgs.Model.Request.MainEventTypeRequest;
import com.EventArgs.Model.Response.MainEventTypeResponse;

public class MainEventTypeService 
{
	MainEventTypeResponse mainEventTypeResponse = new MainEventTypeResponse();
	
	MainEventTypeDAO mainEventTypeDAO;
	
	public MainEventTypeDAO getMainEventTypeDAO() 
	{
		return mainEventTypeDAO;
	}
	public void setMainEventTypeDAO(MainEventTypeDAO mainEventTypeDAO) 
	{
		this.mainEventTypeDAO = mainEventTypeDAO;
	}
	
	public MainEventTypeResponse getMainEventTypes(MainEventTypeRequest request)
	{	
		if((request.getMessage()).equals("Display main events"))
		{
			
			ArrayList<String> names = mainEventTypeDAO.getMainEventTypes();
			ArrayList<String> links = mainEventTypeDAO.getMainEventTypeImageLink();
			
			if((names.size()!=0)&&(links.size()!=0)&&(names.size()==links.size()))
			{
				ArrayList<MainEventType> result = new ArrayList<>();
				
				for(int i = 0; i<names.size(); i++)
				{
					MainEventType mainEventType = new MainEventType();
					
					mainEventType.setMainEventTypeName(names.get(i));
					System.out.println("Name :"+mainEventType.getMainEventTypeName());
					mainEventType.setMainEventTypeImageLink(links.get(i));
					System.out.println("Name :"+mainEventType.getMainEventTypeImageLink());
					mainEventType.setSubEventTypes(mainEventTypeDAO.getSubEventTypes(names.get(i)));
					result.add(i,mainEventType);
				}
				
				mainEventTypeResponse.setMainEventType(result);
			}
		}
		return mainEventTypeResponse;
	}
}
