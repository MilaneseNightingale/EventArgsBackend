package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.AddAddressService;
import com.EventArgs.Model.Request.AddAddressForUserRequest;
import com.EventArgs.Model.Response.AddAddressForUserResponse;

@RestController
public class AddAddressController 
{
	@Autowired
	AddAddressService addAddressService;
	AddAddressForUserResponse response;
	
	@RequestMapping(value = "/AddAddressForUser")
	public AddAddressForUserResponse get(@RequestBody AddAddressForUserRequest request)
	{
		if(addAddressService!=null)
		{
			response = addAddressService.addAddressUser(request);
		}
		return response;
	}
}
