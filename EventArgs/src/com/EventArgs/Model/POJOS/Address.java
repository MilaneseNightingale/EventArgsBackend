package com.EventArgs.Model.POJOS;

public class Address 
{
	private String addressName;
	private String longitude = null;
	private String latitude = null;
	private String street = null;
	private String locality = null;
	private String city = null;
	private String zipCode = null;
	private String state = null;
	private String addressType;
	
	public String getAddressName()
	{
		return addressName;
	}
	public void setAddressName(String addressName) 
	{
		this.addressName = addressName;
	}
	
	public String getLongitude()
	{
		return longitude;
	}
	public void setLongitude(String longitude) 
	{
		this.longitude = longitude;
	}
	
	public String getLatitude() 
	{
		return latitude;
	}
	public void setLatitude(String latitude) 
	{
		this.latitude = latitude;
	}
	
	public String getStreet() 
	{
		return street;
	}
	public void setStreet(String street) 
	{
		this.street = street;
	}
	
	public String getLocality() 
	{
		return locality;
	}
	public void setLocality(String locality) 
	{
		this.locality = locality;
	}
	
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	
	public String getZipCode() 
	{
		return zipCode;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	
	public String getState()
	{
		return state;
	}
	public void setState(String state) 
	{
		this.state = state;
	}
	
	public String getAddressType() 
	{
		return addressType;
	}
	public void setAddressType(String addressType) 
	{
		this.addressType = addressType;
	}
}
