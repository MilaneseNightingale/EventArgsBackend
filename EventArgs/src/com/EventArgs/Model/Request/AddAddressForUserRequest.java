package com.EventArgs.Model.Request;

import com.EventArgs.Model.POJOS.Address;

public class AddAddressForUserRequest
{
	private long userID;
	private int addAddressFormat;
	private String userAddressType;
	private Address address;
	private String message;
	
	public long getUserID()
	{
		return userID;
	}
	public void setUserID(long userID)
	{
		this.userID = userID;
	}
	
	public int getAddAddressFormat()
	{
		return addAddressFormat;
	}
	public void setAddAddressFormat(int addAddressFormat)
	{
		this.addAddressFormat = addAddressFormat;
	}
	
	public Address getAddress() 
	{
		return address;
	}
	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
	public String getUserAddressType() 
	{
		return userAddressType;
	}
	public void setUserAddressType(String userAddressType) 
	{
		this.userAddressType = userAddressType;
	}
	
	
}
