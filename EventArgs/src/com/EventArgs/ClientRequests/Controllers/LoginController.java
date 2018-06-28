package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.LoginService;
import com.EventArgs.Model.Request.LoginRequest;
import com.EventArgs.Model.Response.LoginResponse;

@RestController
public class LoginController 
{
	@Autowired
	LoginService loginService;
	LoginResponse response = new LoginResponse();
	
	@RequestMapping(value = "/Login")
	public LoginResponse get(@RequestBody LoginRequest request)
	{
		if(loginService != null)
		{
			response = loginService.checkDetails(request);
		}
		return response;
	}
}
