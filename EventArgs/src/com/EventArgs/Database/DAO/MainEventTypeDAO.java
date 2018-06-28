package com.EventArgs.Database.DAO;

import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Database.SQLQueries.SQLQueries;

public class MainEventTypeDAO 
{
	private DataSource datasource;
	private JdbcTemplate jdbcObject;
	
	public DataSource getDatasource()
	{
		return datasource;
	}
	
	public void setDatasource(DataSource datasource)
	{
		this.datasource = datasource;
		this.jdbcObject = new JdbcTemplate(datasource);
		if(jdbcObject==null)
		{
			System.out.println("jdbcObject null");
		}
	}
	
	public ArrayList<String> getMainEventTypes()
	{
		String queryForMainEventType = SQLQueries.GET_MAIN_EVENT_TYPES;
		ArrayList<String> response = new ArrayList<>();
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForMainEventType);
			while(result.next())
			{
				response.add(result.getString("eventtype_name"));
				//response.add(result.getString(0));
			}
			
		}catch(DataAccessException e)
		{
			System.out.println("Unable to execute the query");
			System.out.println(e);
		}catch(NullPointerException e)
		{
			System.out.println("No such record exists");
		}catch(Exception e)
		{
			System.out.println("Error in the function");
		}
		
		return response;
	}
	
	public ArrayList<String> getMainEventTypeImageLink()
	{
		String queryForMainEventTypeImageLink = SQLQueries.GET_MAINTYPES_IMAGES;
		ArrayList<String> response = new ArrayList<>();
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForMainEventTypeImageLink);
			while(result.next())
			{
				response.add(result.getString("eventtype_image_link"));
			}
		}catch(DataAccessException e)
		{
			System.out.println("Unable to execute the query");
			System.out.println(e);
		}catch(NullPointerException e)
		{
			System.out.println("No such record exists");
		}catch(Exception e)
		{
			System.out.println("Error in the function");
		}
		
		return response;
	}
	
	public ArrayList<String> getSubEventTypes(String parentEventType)
	{
		String queryForSubTypes = SQLQueries.GET_SUB_EVENT_TYPES;
		ArrayList<String> response = new ArrayList<>();
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForSubTypes,parentEventType);
			while(result.next())
			{
				response.add(result.getString("eventtype_name"));
				//response.add(result.getString(0));
			}
			
		}catch(DataAccessException e)
		{
			System.out.println("Unable to execute the query");
			System.out.println(e);
		}catch(NullPointerException e)
		{
			System.out.println("No such record exists");
		}catch(Exception e)
		{
			System.out.println("Error in the function");
		}
		
		return response;
	}
	
}
