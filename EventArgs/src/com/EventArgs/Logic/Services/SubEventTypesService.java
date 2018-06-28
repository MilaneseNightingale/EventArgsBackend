package com.EventArgs.Logic.Services;

import java.util.ArrayList;

import com.EventArgs.Database.DAO.SubEventTypesDAO;
import com.EventArgs.Model.Request.SubEventTypesRequest;
import com.EventArgs.Model.Response.SubEventTypesResponse;

public class SubEventTypesService 
{
	SubEventTypesResponse response = new SubEventTypesResponse();
	SubEventTypesDAO subEventTypesDAO;
	
	public SubEventTypesDAO getSubEventTypesDAO() 
	{
		return subEventTypesDAO;
	}
	public void setSubEventTypesDAO(SubEventTypesDAO subEventTypesDAO) 
	{
		this.subEventTypesDAO = subEventTypesDAO;
	}
	
	public SubEventTypesResponse getSubTypes(SubEventTypesRequest request)
	{
		ArrayList<String> result = new ArrayList<>();
		if((request.getMessage()).equals("Display sub events"))
		{
			result = subEventTypesDAO.getSubEventTypes(request.getParentEventType());
		}
		if(result.size()==0)
		{
			response.setMessage("Error! no more subtypes");
		}
		else
		{
			response.setMessage("Got sub event types");
		}
		response.setListOfEvents(result);
		
		return response;
	}
}
