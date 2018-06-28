package com.EventArgs.ClientRequests.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EventArgs.Logic.Services.SearchService;
import com.EventArgs.Model.Request.SearchRequest;
import com.EventArgs.Model.Response.SearchForEventTypesResponse;
import com.EventArgs.Model.Response.SearchForItemShopHandlerResponse;

@RestController
public class SearchController 
{
	@Autowired
	SearchService searchService;
	SearchForEventTypesResponse response1 = new SearchForEventTypesResponse();
	SearchForItemShopHandlerResponse response2 = new SearchForItemShopHandlerResponse();
	
	@RequestMapping(value = "/SearchEventTypes")
	public SearchForEventTypesResponse getEventTypeResults(@RequestBody SearchRequest request)
	{
		if(response1!=null)
		{
			response1 = searchService.searchForEventTypes(request);
		}
		return response1;
	}
	
	@RequestMapping(value = "/SearchItemShopHandler")
	public SearchForItemShopHandlerResponse getMainResults(@RequestBody SearchRequest request)
	{
		if(response2!=null)
		{
			response2 = searchService.mainSearch(request);
		}
		return response2;
	}
	
}
