package com.EventArgs.Model.POJOS;

import java.io.InputStream;

public class Shops 
{
	private String shopName;
	private long addressID = -1;
	private String shopRegID = null;
	private long shopPhNo = -1;
	private String shopEmailID = null;
	private InputStream shopPictures = null;
	
	public String getShopName() 
	{
		return shopName;
	}
	public void setShopName(String shopName) 
	{
		this.shopName = shopName;
	}
	
	public long getAddressID() 
	{
		return addressID;
	}
	public void setAddressID(long addressID) 
	{
		this.addressID = addressID;
	}
	
	public String getShopRegID()
	{
		return shopRegID;
	}
	public void setShopRegID(String shopRegID)
	{
		this.shopRegID = shopRegID;
	}
	
	public long getShopPhNo() 
	{
		return shopPhNo;
	}
	public void setShopPhNo(long shopPhNo) 
	{
		this.shopPhNo = shopPhNo;
	}
	
	public String getShopEmailID() 
	{
		return shopEmailID;
	}
	public void setShopEmailID(String shopEmailID) 
	{
		this.shopEmailID = shopEmailID;
	}
	
	public InputStream getShopPictures() 
	{
		return shopPictures;
	}
	public void setShopPictures(InputStream shopPictures) 
	{
		this.shopPictures = shopPictures;
	}

}
