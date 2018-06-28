//package com.EventArgs.Logic.Services;
//
//import com.EventArgs.Database.DAO.MainDisplayDAO;
//import com.EventArgs.Database.Validations.ValidateUserRequests;
//import com.EventArgs.Model.Request.MainDisplayRequest;
//import com.EventArgs.Model.Response.MainDisplayResponse;
//
//public class MainDisplayService
//{
//	private MainDisplayDAO displayDAO;
//
//	public MainDisplayDAO getDisplayDAO() 
//	{
//		return displayDAO;
//	}
//	public void setDisplayDAO(MainDisplayDAO displayDAO)
//	{
//		this.displayDAO = displayDAO;
//	}
//	
//	ValidateUserRequests validation;
//	MainDisplayResponse response = new MainDisplayResponse();
//	
//	public MainDisplayResponse displayResults(MainDisplayRequest request)
//	{
//		response.setUserID(request.getUserID());
//		if(validation.validateRequest(request.getUserID()))
//		{
//			if(request.getMessage().equals("Main Display!! !"))
//			{
//				
//			}
//		}
//	}
//}
