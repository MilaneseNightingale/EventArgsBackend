package com.EventArgs.Details.BaseClasses;

/**
 * This class has the details that have to be stored for the 
 * service providers like event handlers , venues and shops
 * @author Sunaina
 *
 */
public class ServiceProviders extends Details 
{
	protected String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
