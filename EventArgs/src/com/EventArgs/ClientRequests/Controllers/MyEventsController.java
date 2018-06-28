package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.MyEventsService;
import com.EventArgs.Model.Request.MyEventsRequest;
import com.EventArgs.Model.Response.MyEventsResponse;

@RestController
public class MyEventsController 
{
	@Autowired
	MyEventsService myEventService;
	MyEventsResponse response;
	
	@RequestMapping(value = "/MyEvents")
	public MyEventsResponse get(@RequestBody MyEventsRequest request)
	{
		if(myEventService != null)
		{
			response = myEventService.myEvents(request);
		}
		
		return response;
	}
}
