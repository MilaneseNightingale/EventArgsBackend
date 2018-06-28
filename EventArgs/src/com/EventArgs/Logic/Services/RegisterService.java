package com.EventArgs.Logic.Services;

import com.EventArgs.Database.DAO.RegisterDAO;
import com.EventArgs.Model.Request.UserCheckEmailExistenceRequest;
import com.EventArgs.Model.Request.RegisterRequest;
import com.EventArgs.Model.Response.UserCheckEmailExistenceResponse;
import com.EventArgs.Model.Response.RegisterResponse;


public class RegisterService
{
	RegisterDAO registerDao;
	
	public RegisterDAO getRegisterDao() 
	{
		return registerDao;
	}
	
	public void setRegisterDao(RegisterDAO registerDao)
	{
		System.out.println("DAO");
		this.registerDao = registerDao;
	}
	
	RegisterResponse response1 = new RegisterResponse();
	UserCheckEmailExistenceResponse response2 = new UserCheckEmailExistenceResponse(); 
	
	/**
	 * This function registers a normal user
	 * @param request
	 * @return response to check whether the registration was successful or not
	 */
	public RegisterResponse registerUser(RegisterRequest request)
	{
		if(request.getUserType().equals("Normal User"))
		{
			long userID = registerDao.insertUser(request.getUser());
			response1.setUserID(userID);
			if(userID != -1)
			{
				response1.setStatus("Success");
				response1.setMessage("User Registered successfully");
				return response1;
			}
		}
		response1.setUserID(-1);
		response1.setStatus("Failure");
		response1.setMessage("User Registered unsuccessfully");
		return response1;
	}
	
	/**
	 * This function is used while entering the email in the registration page to check whether the email already exists or not 
	 * @param request
	 * @return response to check whether it exists
	 */
	public UserCheckEmailExistenceResponse checkEmail(UserCheckEmailExistenceRequest request)
	{
		if(request.getMessage().equals("Check for email Existence"))
		{
			response2.setItExists((registerDao.checkExistenceOfPerson(request.getEmail())==-1)?false:true);
		}
		return response2;
	}
	
	/**
	 * This function will register the user and then also register them as a Shop Owner or Venue Manager
	 * @param request
	 * @return response to check whether the registration occured or not
	 */
	public RegisterResponse registerOwner(RegisterRequest request)
	{
		if((request.getUserType().equals("Shop Owner"))||(request.getUserType().equals("Venue Manager")))
		{
			long userID = registerDao.insertUser(request.getUser());
			if(userID != -1)
			{
				if(registerDao.addOwner(userID, request.getUser().getRegID(), request.getUser().getAadharNo(),request.getUserType()))
				{
					response1.setStatus("Success");
					response1.setMessage(request.getUserType() + " registered successfully");
					return response1;
				}
			}
		}
		response1.setStatus("Failure");
		response1.setMessage(request.getUserType() + " registered unsuccessfully");
		return response1;
	}
}
