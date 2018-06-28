package com.EventArgs.Logic.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.EventArgs.Database.DAO.CreateNewEventDAO;
import com.EventArgs.Database.Validations.ValidateUserRequests;
import com.EventArgs.Model.POJOS.Events;
import com.EventArgs.Model.Request.CreateNewEventRequest;
import com.EventArgs.Model.Response.CreateNewEventResponse;

public class CreateNewEventService 
{
	CreateNewEventDAO createNewEventDAO;
	CreateNewEventResponse response = new CreateNewEventResponse();
	
	@Autowired
	ValidateUserRequests validation;

	public CreateNewEventDAO getCreateNewEventDAO()
	{
		return createNewEventDAO;
	}
	public void setCreateNewEventDAO(CreateNewEventDAO createNewEventDAO) 
	{
		this.createNewEventDAO = createNewEventDAO;
	}
	
	public CreateNewEventResponse createNewEvent(CreateNewEventRequest request)
	{
		Events event = request.getCreateNewEvent();
		if(validation.validateRequest(event.getUserID()))
		{
			if(createNewEventDAO.createEvent(request.getCreateNewEvent()))
			{
				response.setUserID((request.getCreateNewEvent()).getUserID());
				response.setMessage("New Event Created");
			}
			else
			{
				response.setUserID((request.getCreateNewEvent()).getUserID());
				response.setMessage("Error in creating a new event");
			}
		}
		else
		{
			response.setUserID((request.getCreateNewEvent()).getUserID());
			response.setMessage("No such user registered");
		}
		return response;
	}
}
