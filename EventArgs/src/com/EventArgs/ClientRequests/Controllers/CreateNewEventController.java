package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.CreateNewEventService;
import com.EventArgs.Model.Request.CreateNewEventRequest;
import com.EventArgs.Model.Response.CreateNewEventResponse;

@RestController
public class CreateNewEventController 
{
	@Autowired
	CreateNewEventService createNewEventService;
	CreateNewEventResponse response = new CreateNewEventResponse();
	
	@RequestMapping(value = "/CreateNewEvent")
	public CreateNewEventResponse get(@RequestBody CreateNewEventRequest request)
	{
		if(createNewEventService!=null)
		{
			response = createNewEventService.createNewEvent(request);
		}
		else
		{
			response.setUserID(request.getCreateNewEvent().getUserID());
			response.setMessage("Error in Service layer");
		}
		return response;
	}
}
