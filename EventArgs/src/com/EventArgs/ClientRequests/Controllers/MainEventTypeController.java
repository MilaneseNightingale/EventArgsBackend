package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.MainEventTypeService;
import com.EventArgs.Model.Request.MainEventTypeRequest;
import com.EventArgs.Model.Response.MainEventTypeResponse;

//@CrossOrigin(origins = {"http://192.168.43.244:8080"})
@RestController
public class MainEventTypeController 
{
	@Autowired
	MainEventTypeService mainEventTypeService;
	MainEventTypeResponse response ;
	
	@RequestMapping(value = "/MainEventType" ,method = RequestMethod.POST)
	public MainEventTypeResponse get(@RequestBody MainEventTypeRequest request)
	{
		if(mainEventTypeService!=null)
		{
			response = mainEventTypeService.getMainEventTypes(request);
		}
		return response;
	}
}
