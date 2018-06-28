package com.EventArgs.Model.Request;

import com.EventArgs.Model.POJOS.Users;

public class RegisterRequest 
{
	private Users user;
	private String userType;

	public Users getUser()
	{
		return user;
	}
	public void setUser(Users user) 
	{
		this.user = user;
	}
	
	public String getUserType() 
	{
		return userType;
	}
	public void setUserType(String userType) 
	{
		this.userType = userType;
	}
	
}
