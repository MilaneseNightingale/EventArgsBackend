package com.EventArgs.Model.Response;

import java.util.ArrayList;

import com.EventArgs.Model.POJOS.SearchResultsForItemShopHandler;

public class SearchForItemShopHandlerResponse
{
	private long userID;
	private ArrayList<SearchResultsForItemShopHandler> allResults;
	private String message;
	
	public long getUserID() 
	{
		return userID;
	}
	public void setUserID(long userID)
	{
		this.userID = userID;
	}
	
	public ArrayList<SearchResultsForItemShopHandler> getResults()
	{
		return allResults;
	}
	public void setResults(ArrayList<SearchResultsForItemShopHandler> allResults)
	{
		this.allResults = allResults;
	}
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
}
