package com.EventArgs.Database.DAO;

import java.sql.Connection;
import java.sql.Date;
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
import com.EventArgs.Model.POJOS.Users;

public class RegisterDAO 
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
	
	/**
	 * It checks the existence of the email in the database
	 * @param email
	 * @return userID if it exists or else -1
	 */
	public int checkExistenceOfPerson(String email)
	{
		String queryForExistence = SQLQueries.CHECK_FOR_USER_EXISTENCE;
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForExistence,email);
			
			if(result.next())
			{
				return result.getInt("user_id");
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
	
	/**
	 * It adds the details of the user into the database
	 * @param user
	 * @return Returns the userID(long)
	 */
	public long insertUser(Users user)
	{
		String registerUserQuery = SQLQueries.REGISTER_USER;
		long userID = -1;
		try
		{
			long phNo = Long.parseLong(user.getPhoneNumber());
			Date dob = Date.valueOf(user.getDOB());

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcObject.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(registerUserQuery, new String[] {"id"});
			            ps.setString(1, (user.getFirstName()));
			            ps.setString(2, (user.getLastName()));
			            ps.setLong(3, (phNo));
			            ps.setString(4, user.getUniqueWord());
			            ps.setString(5, user.getEmail());
			            ps.setDate(6, dob);
			            return ps;
			        }
			    }, keyHolder);
			userID = (long) keyHolder.getKey();
		}catch(DataAccessException e)
		{
			System.out.println("Error in inserting user");
			e.printStackTrace();
		}
		return userID;
	}
	
	/**
	 * Depending on the userType the respective table is filled with the data
	 * @param userID
	 * @param regID
	 * @param aadharNo
	 * @param userType
	 * @return returns true if successful else false
	 */
	public boolean addOwner(long userID,String regID,String aadharNo,String userType)
	{
		String insertQuery = null;
		if(userType.equals("Shop Owner"))
			insertQuery = SQLQueries.ADD_SHOP_OWNER;
		if(userType.equals("Venue Manager"))
			insertQuery = SQLQueries.ADD_VENUE_MANAGER;
		
		try
		{
			int i = jdbcObject.update(insertQuery, userID,regID,aadharNo);
			if(i != 0)
			{
				return true;
			}
		}catch(DataAccessException e)
		{
			System.out.println("Unable to execute the query");
			System.out.println(e);
		}catch(NullPointerException e)
		{
			System.out.println("Query is null");
			return false;
		}catch(Exception e)
		{
			System.out.println("Error in the function");
		}
		return false;
	}
}
