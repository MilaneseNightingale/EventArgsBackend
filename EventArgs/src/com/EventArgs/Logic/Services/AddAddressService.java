package com.EventArgs.Logic.Services;

import org.springframework.beans.factory.annotation.Autowired;

import com.EventArgs.Database.DAO.AddAddressDAO;
import com.EventArgs.Database.Validations.ValidateUserRequests;
import com.EventArgs.Model.POJOS.Address;
import com.EventArgs.Model.Request.AddAddressForUserRequest;
import com.EventArgs.Model.Response.AddAddressForUserResponse;

public class AddAddressService 
{
	@Autowired
	ValidateUserRequests validation;
	
	AddAddressDAO addAddressDAO;
	AddAddressForUserResponse response = new AddAddressForUserResponse();
	
	public AddAddressDAO getAddAddressDAO()
	{
		return addAddressDAO;
	}
	public void setAddAddressDAO(AddAddressDAO addAddressDAO) 
	{
		this.addAddressDAO = addAddressDAO;
	}
	
	public AddAddressForUserResponse addAddressUser(AddAddressForUserRequest request)
	{
		response.setUserID(request.getUserID());
		Address address = request.getAddress();
		
		if(validation.validateRequest(request.getUserID()))
		{
			if(((request.getMessage()).equals("Add Address For user"))&&((address.getAddressType()).equals("Normal User")))
			{
				long addressID = -1;
				if(request.getAddAddressFormat()==0)
				{
					addressID = addAddressDAO.checkAddress(address.getLongitude(), address.getLatitude());
					if(addressID == -1)
					{
						addressID = addAddressDAO.addAddress(request);
						if(addressID==-1)
						{
							response.setMessage("Error adding the address into the database");
						}
					}
				}
				else if(request.getAddAddressFormat()==1)
				{
					addressID = addAddressDAO.checkAddressPresence(request.getAddress().getStreet());
					if(addressID == -1)
					{
						addressID = addAddressDAO.insertAddress(request);
						if(addressID == -1)
						{
							response.setMessage("Error adding the address into the database");
						}
					}
				}
				if(addressID > 0)
				{
					if(addAddressDAO.addUserAddress(request.getUserID(), addressID, request.getUserAddressType()))
					{
						response.setMessage("Added the AddRess For tHe user");
					}
					else
					{
						response.setMessage("Duplicate address!Address already has been added");
					}
				}
			}
		}
		return response;
	}
}
