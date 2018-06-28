package com.EventArgs.Model.Response;

public class AddShopResponse 
{
	private long shopOwner;
	private String message;
	
	public long getShopOwner()
	{
		return shopOwner;
	}
	public void setShopOwner(long shopOwner) 
	{
		this.shopOwner = shopOwner;
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
