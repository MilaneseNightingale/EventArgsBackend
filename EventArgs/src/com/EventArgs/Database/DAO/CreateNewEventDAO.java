package com.EventArgs.Database.DAO;

import java.sql.Date;
import java.sql.Time;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.EventArgs.Database.SQLQueries.SQLQueries;
import com.EventArgs.Model.POJOS.Events;

public class CreateNewEventDAO 
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
	
	public boolean createEvent(Events event)
	{
		String insertQuery = SQLQueries.CREATE_NEW_EVENT;
		try
		{
			Date dateFrom = Date.valueOf(event.getDateFrom());
			Date dateTo = Date.valueOf(event.getDateTo());
			
			Time timeFrom = Time.valueOf(event.getTimeFrom());
			Time timeTo = Time.valueOf(event.getTimeTo());
			
			int i = jdbcObject.update(insertQuery, event.getEventName(),dateFrom,dateTo,timeFrom,timeTo,event.getUserID(),event.getStatus());
			if(i!=0)
			{
				return true;
			}
		}catch(DataAccessException e)
		{
			System.out.println("Error in inserting user");
			e.printStackTrace();
		}
		return false;
	}
}
