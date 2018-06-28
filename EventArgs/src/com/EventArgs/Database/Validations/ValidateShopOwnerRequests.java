package com.EventArgs.Database.Validations;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Database.SQLQueries.SQLQueries;

public class ValidateShopOwnerRequests
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
		jdbcObject = new JdbcTemplate(datasource);
		if(jdbcObject==null)
		{
			System.out.println("jdbcObject null");
		}
	}
	
	public boolean validateRequest(long sessionID)
	{
		String queryForValidationOfRequests = SQLQueries.VALIDATE_SHOP_OWNER_REQUESTS;
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForValidationOfRequests,sessionID);
			if(result.next())
			{
				return true;
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
		return false;
	}
}
