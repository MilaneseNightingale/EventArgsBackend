package com.EventArgs.Logic.Services;

import com.EventArgs.Database.DAO.SearchDAO;
import com.EventArgs.Database.Validations.ValidateUserRequests;
import com.EventArgs.Model.Request.SearchRequest;
import com.EventArgs.Model.Response.SearchForEventTypesResponse;
import com.EventArgs.Model.Response.SearchForItemShopHandlerResponse;

public class SearchService
{
	SearchDAO searchDAO;

	public SearchDAO getSearchDAO() 
	{
		return searchDAO;
	}
	public void setSearchDAO(SearchDAO searchDAO)
	{
		this.searchDAO = searchDAO;
	}
	
	SearchForEventTypesResponse response1 = new SearchForEventTypesResponse();
	SearchForItemShopHandlerResponse response2 = new SearchForItemShopHandlerResponse();
	ValidateUserRequests validation;
	
	public ValidateUserRequests getValidation()
	{
		return validation;
	}
	public void setValidation(ValidateUserRequests validation) 
	{
		this.validation = validation;
	}
	
	public SearchForEventTypesResponse searchForEventTypes(SearchRequest request)
	{
		response1.setUserID(request.getUserID());
		if((validation.validateRequest(request.getUserID()))||(request.getUserID()==-1))
		{
			if((request.getMessage()).equals("Searchinggggg"))
			{
				response1.setEventTypes(searchDAO.getEventTypes(request.getText()));
				if(response1.getEventTypes().size()==0)
				{
					response1.setMessage("No Result");
				}
			}
			else
			{
				response1.setMessage("Wrong message");
			}
		}
		else
		{
			response1.setMessage("Wrong userID");
		}
		
		return response1;
	}
	
	public SearchForItemShopHandlerResponse mainSearch(SearchRequest request)
	{
		response2.setUserID(request.getUserID());
		if(validation.validateRequest(request.getUserID()))
		{
			if((request.getMessage()).equals("Main search woooohooo"))
			{
				response2.setResults(searchDAO.getMainSearchResults(request.getText()));
				if(response2.getResults()==null)
				{
					response2.setMessage("No such ITEM SHOP and EVENT HANDLER");
				}
				else
				{
					response2.setMessage("Got search results!!");
				}
			}
			else
			{
				response2.setMessage("Wrong message");
			}
		}
		else
		{
			response2.setMessage("Wrong userID");
		}
		
		return response2;
	}
}
