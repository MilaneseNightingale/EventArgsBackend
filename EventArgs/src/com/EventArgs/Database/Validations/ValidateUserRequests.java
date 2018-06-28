package com.EventArgs.Database.Validations;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Database.SQLQueries.SQLQueries;

public class ValidateUserRequests
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
	
	/** 
	 * This function is used for security reasons to see whether the request received is from a valid source
	 * @param sessionID
	 * @return
	 */
	public boolean validateRequest(long sessionID)
	{
		String queryForValidationOfRequests = SQLQueries.VALIDATE_USER_REQUESTS;
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForValidationOfRequests);
			//jdbcObject.quer
			if(result.next())
			{
				return true;
			}
			
//			Integer result = jdbcObject.queryForObject(queryForValidationOfRequests, Integer.class, sessionID);
//			if(result!=null)
//			{
//				return true;
//			}
			
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
