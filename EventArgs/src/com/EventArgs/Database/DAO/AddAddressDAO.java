package com.EventArgs.Database.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Database.SQLQueries.SQLQueries;
import com.EventArgs.Model.Request.AddAddressForUserRequest;

public class AddAddressDAO 
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
	
	public long checkAddress(String longitude, String latitude)
	{
		String query = SQLQueries.CHECK_ADDRESS_EXISTENCE;
		long addressID = -1;
		
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(query, longitude, latitude);
			if(result.next())
			{
				addressID = result.getLong("address_id");
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
		
		return addressID;
	}
	
	public boolean addUserAddress(long userID, long addressID, String status)
	{
		String query = SQLQueries.ADD_USER_ADDRESS;
		
		try
		{
			int i = jdbcObject.update(query, userID,addressID,status);
			if(i != 0)
			{
				return true;
			}
			
		}catch(DataAccessException e)
		{
			System.out.println("Unable to execute the query");
			System.out.println(e);
			return false;
		}catch(NullPointerException e)
		{
			System.out.println("No such record exists");
		}catch(Exception e)
		{
			System.out.println("Error in the function");
		}
		
		return false;
	}
	
	public long addAddress(AddAddressForUserRequest request)
	{
		String insertQuery = SQLQueries.ADD_ADDRESS;
		long addressID = -1;
		try
		{	
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcObject.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(insertQuery, new String[] {"id"});
			            ps.setString(1, (request.getAddress()).getAddressName());
			            ps.setString(2, (request.getAddress()).getLongitude());
			            ps.setString(3, (request.getAddress()).getLatitude());
			            return ps;
			        }
			    }, keyHolder);
			addressID = (long) keyHolder.getKey();
		
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
		
		return addressID;
	}
	
	public long checkAddressPresence(String street)
	{
		String checkQuery = SQLQueries.CHECK_STREET_ADDRESS;
		long addressID = -1;
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(checkQuery, street);
			if(result.next())
			{
				addressID = result.getLong("address_id");
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
		return addressID;
	}
	
	public long insertAddress(AddAddressForUserRequest request)
	{
		String insertQuery = SQLQueries.ADD_ADDRESS_TEXT;
		long addressID = -1;
		try
		{
//			int i = jdbcObject.update(insertQuery, request.getAddress().getStreet(),request.getAddress().getLocality(),
//					request.getAddress().getCity(),request.getAddress().getZipCode(),request.getAddress().getState());
//			if(i != 0)
//			{
//				return true;
//			}
			
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcObject.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(insertQuery, new String[] {"id"});
			            ps.setString(1, (request.getAddress()).getAddressName());
			            ps.setString(2, (request.getAddress()).getStreet());
			            ps.setString(3, (request.getAddress()).getLocality());
			            ps.setString(4, (request.getAddress()).getCity());
			            ps.setString(5, (request.getAddress()).getZipCode());
			            ps.setString(6, (request.getAddress()).getState());
			            return ps;
			        }
			    }, keyHolder);
			addressID = (long) keyHolder.getKey();
			
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
		
		return addressID;
	}
}
