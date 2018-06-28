package com.EventArgs.Model.POJOS;

import java.util.ArrayList;

public class Items 
{
	private String itemName;
	private char hasSubTypes = ' ';
	private ArrayList<String> subTypes = null;
	
	public String getItemName()
	{
		return itemName;
	}
	public void setItemName(String itemName)
	{
		this.itemName = itemName;
	}
	
	public char getHasSubTypes()
	{
		return hasSubTypes;
	}
	public void setHasSubTypes(char hasSubTypes) 
	{
		this.hasSubTypes = hasSubTypes;
	}
	
	public ArrayList<String> getSubTypes()
	{
		return subTypes;
	}
	public void setSubTypes(ArrayList<String> subTypes) 
	{
		this.subTypes = subTypes;
	}
}
