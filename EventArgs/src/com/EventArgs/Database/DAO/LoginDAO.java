package com.EventArgs.Database.DAO;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Database.SQLQueries.SQLQueries;
import com.EventArgs.Model.Request.LoginRequest;

public class LoginDAO
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
	
	public long getUserID(LoginRequest request)
	{
		String query = SQLQueries.CHECK_LOGIN_DETAILS;
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(query, request.getEmail(),request.getPassword());
			if(result.next())
			{
				return result.getLong("user_id");
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
		return -1;
	}
	
	public long[] getOwnerID(long userID)
	{
		String query = SQLQueries.GET_SHOP_OWNER_ID;
		long[] result = new long[2]; 
		Arrays.fill(result, -1);
		try
		{
			SqlRowSet data = jdbcObject.queryForRowSet(query, userID);
			if(data.next())
			{
				result[0] = data.getLong("owner_id");
			}
			
			query = SQLQueries.GET_VENUE_MANAGER_ID;
			data = jdbcObject.queryForRowSet(query, userID);
			if(data.next())
			{
				result[1] = data.getLong("vmanager_id");
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
		
		return result;
	}
}
