package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.SubEventTypesService;
import com.EventArgs.Model.Request.SubEventTypesRequest;
import com.EventArgs.Model.Response.SubEventTypesResponse;

@RestController
public class SubEventTypesController
{
	@Autowired
	SubEventTypesService subEventTypeService;
	SubEventTypesResponse response;
	
	@RequestMapping(value = "/SubEventTypes")
	public SubEventTypesResponse get(@RequestBody SubEventTypesRequest request)
	{
		if(subEventTypeService!=null)
		{
			response = subEventTypeService.getSubTypes(request);
		}
		
		return response;
	}
}
