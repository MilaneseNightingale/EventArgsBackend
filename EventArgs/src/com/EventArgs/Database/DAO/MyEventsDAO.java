package com.EventArgs.Database.DAO;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Database.SQLQueries.SQLQueries;
import com.EventArgs.Model.POJOS.Events;

public class MyEventsDAO 
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
	
	public ArrayList<Events> getMyEvents(long userID)
	{
		String queryForMyEvents = SQLQueries.GET_MY_EVENTS;
		ArrayList<Events> response = new ArrayList<Events>();
		
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(queryForMyEvents, userID);
			while(result.next())
			{
				Events event = new Events();
				event.setEventName(result.getString("event_name"));
				
				String dateFrom = correctDate(result.getDate("date_from"));
				event.setDateFrom(dateFrom); 
				
				String dateTo = correctDate(result.getDate("date_to"));
				event.setDateTo(dateTo);
				
//				event.setTimeFrom((result.getTime("time_from")).toString());
//				event.setTimeTo((result.getTime("time_to")).toString());
				
				String timeFrom = correctTime((result.getTime("time_from")).toString());
				event.setTimeFrom(timeFrom);
				
				String timeTo = correctTime((result.getTime("time_to")).toString());
				event.setTimeTo(timeTo);
				
				event.setUserID(result.getInt("user_id"));
				event.setStatus(result.getString("event_status"));
				response.add(event);
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
	
	public String correctDate(Date date)
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		return df.format(date);
	}
	
	public String correctTime(String time)
	{	
		return time.substring(0, 5);
	}
}
