package com.EventArgs.Logic.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.EventArgs.Database.DAO.AddShopDAO;
import com.EventArgs.Database.Validations.ValidateShopOwnerRequests;
import com.EventArgs.Model.Request.AddShopRequest;
import com.EventArgs.Model.Response.AddShopResponse;

public class AddShopService 
{
	private AddShopDAO addShopDAO;
	private AddShopResponse response = new AddShopResponse();
	
	@Autowired
	private ValidateShopOwnerRequests validation;
	
	public AddShopDAO getAddShopDAO()
	{
		return addShopDAO;
	}
	public void setAddShopDAO(AddShopDAO addShopDAO)
	{
		this.addShopDAO = addShopDAO;
	}
	
	public AddShopResponse addShop(AddShopRequest request)
	{
		if(validation.validateRequest(request.getOwnerID()))
		{
			if(addShopDAO.addShop(request.getAddShop()))
			{
				response.setShopOwner(request.getOwnerID());
				response.setMessage("Add the shop");
			}
			else
			{
				response.setShopOwner(request.getOwnerID());
				response.setMessage("Not able to add the shop");
			}
		}
		else
		{
			response.setShopOwner(request.getOwnerID());
			response.setMessage("No such shop owner present");
		}
		return response;
	}
	
}
