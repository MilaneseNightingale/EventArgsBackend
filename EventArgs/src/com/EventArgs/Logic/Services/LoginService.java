package com.EventArgs.Logic.Services;

import com.EventArgs.Database.DAO.LoginDAO;
import com.EventArgs.Model.Request.LoginRequest;
import com.EventArgs.Model.Response.LoginResponse;

public class LoginService
{
	private LoginDAO loginDAO;
	
	public LoginDAO getLoginDAO() 
	{
		return loginDAO;
	}
	public void setLoginDAO(LoginDAO loginDAO) 
	{
		this.loginDAO = loginDAO;
	}
	
	LoginResponse response = new LoginResponse();
	
	public LoginResponse checkDetails(LoginRequest request)
	{
		long userID = loginDAO.getUserID(request);
		response.setUserID(userID);
		if(userID!=-1)
		{
			response.setMessage("Successful Login Attempt");
		}
		else
		{
			response.setMessage("Unsuccessful Login Attempt");
		}
		long[] data = loginDAO.getOwnerID(userID); 
		response.setShopOwnerID(data[0]);
		response.setVenueManagerID(data[1]);
		return response;
	}
}