package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.AddShopService;
import com.EventArgs.Model.Request.AddShopRequest;
import com.EventArgs.Model.Response.AddShopResponse;

@RestController
public class AddShopController 
{
	@Autowired
	AddShopService addShopService;
	AddShopResponse response;
	
	@RequestMapping(value = "/AddShop")
	public AddShopResponse get(@RequestBody AddShopRequest request)
	{
		response = addShopService.addShop(request);
		return response;
	}
	
}
