package com.EventArgs.Model.Request;

import com.EventArgs.Model.POJOS.Shops;

public class AddShopRequest 
{
	Shops addShop;
	private long ownerID;
	
	public Shops getAddShop() 
	{
		return addShop;
	}
	public void setAddShop(Shops addShop)
	{
		this.addShop = addShop;
	}
	
	public long getOwnerID() 
	{
		return ownerID;
	}
	public void setOwnerID(long ownerID)
	{
		this.ownerID = ownerID;
	}
	
}
