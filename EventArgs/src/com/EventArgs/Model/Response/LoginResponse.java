package com.EventArgs.Model.Response;

public class LoginResponse 
{
	private long userID;
	private long shopOwnerID;
	private long venueManagerID;
	private String message;
	
	public long getUserID() 
	{
		return userID;
	}
	public void setUserID(long userID) 
	{
		this.userID = userID;
	}
	
	public long getShopOwnerID()
	{
		return shopOwnerID;
	}
	public void setShopOwnerID(long shopOwnerID) 
	{
		this.shopOwnerID = shopOwnerID;
	}
	
	public long getVenueManagerID() 
	{
		return venueManagerID;
	}
	public void setVenueManagerID(long venueManagerID) 
	{
		this.venueManagerID = venueManagerID;
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
