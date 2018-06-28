package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.RegisterService;
import com.EventArgs.Model.Request.RegisterRequest;
import com.EventArgs.Model.Request.UserCheckEmailExistenceRequest;
import com.EventArgs.Model.Response.UserCheckEmailExistenceResponse;
import com.EventArgs.Model.Response.RegisterResponse;

@RestController
public class RegisterController 
{
	RegisterResponse response1 = new RegisterResponse();
	UserCheckEmailExistenceResponse response2 = new UserCheckEmailExistenceResponse();
	@Autowired
	RegisterService registerService;

	/**
	 * This function is used to register a normal user
	 * @param request
	 * @return
	 */
	@RequestMapping(value ="/Register/User")
	public RegisterResponse get(@RequestBody RegisterRequest request)
	{
		if(registerService!=null)
		{
			response1 =  registerService.registerUser(request);
		}
		else
		{
			response1.setStatus("Unsuccessful!!");
			response1.setMessage("Error in the controller!!");
		}
		return response1;
	}
	
	/**
	 * This function is used to check whether the email entered by the User already exists or not
	 * If it exists registration is not allowed
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/Register/CheckEmail")
	public UserCheckEmailExistenceResponse get(@RequestBody UserCheckEmailExistenceRequest request)
	{
		if(registerService!=null)
		{
			response2 = registerService.checkEmail(request);
		}
		return response2;
	}
	
	/**
	 * This function is used to register the owner i.e a shop owner or a venue manager
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/Register/Owner")
	public RegisterResponse getResponse(@RequestBody RegisterRequest request)
	{
		if(registerService != null)
		{
			response1 = registerService.registerOwner(request);
		}
		return response1;
	}
}
