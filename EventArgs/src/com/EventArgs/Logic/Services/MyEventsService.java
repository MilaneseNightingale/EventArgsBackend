package com.EventArgs.Logic.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.EventArgs.Database.DAO.MyEventsDAO;
import com.EventArgs.Database.Validations.ValidateUserRequests;
import com.EventArgs.Model.Request.MyEventsRequest;
import com.EventArgs.Model.Response.MyEventsResponse;

public class MyEventsService 
{
	MyEventsDAO myEventsDAO;
	MyEventsResponse response = new MyEventsResponse();
	
	@Autowired
	ValidateUserRequests validation;
	
	public MyEventsDAO getMyEventsDAO()
	{
		return myEventsDAO;
	}
	public void setMyEventsDAO(MyEventsDAO myEventsDAO)
	{
		this.myEventsDAO = myEventsDAO;
	}
	
	public MyEventsResponse myEvents(MyEventsRequest request)
	{
		if(validation.validateRequest(request.getUserID()))
		{
			if((request.getMessage()).equalsIgnoreCase("Get My Events"))
			{
				response.setMyEvents(myEventsDAO.getMyEvents(request.getUserID()));
				if(response.getMyEvents()==null)
				{
					response.setMessage("No events found for the user");
				}
				else
				{
					response.setMessage("Got my events");
				}
			}
			else
			{
				response.setMessage("Incorrect!!");
			}
		}
		else
		{
			response.setMessage("Such user doesnt exist");
		}
		response.setUserID(request.getUserID());
		return response;
	}
}
