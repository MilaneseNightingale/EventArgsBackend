//package com.EventArgs.Database.DAO;
//
//import java.util.ArrayList;
//
//import javax.sql.DataSource;
//
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.rowset.SqlRowSet;
//
//import com.EventArgs.Database.SQLQueries.SQLQueries;
//import com.EventArgs.Model.POJOS.Items;
//import com.EventArgs.Model.POJOS.Shops;
//
//public class MainDisplayDAO 
//{
//	private DataSource datasource;
//	private JdbcTemplate jdbcObject;
//	
//	public DataSource getDatasource()
//	{
//		return datasource;
//	}
//	
//	public void setDatasource(DataSource datasource)
//	{
//		this.datasource = datasource;
//		this.jdbcObject = new JdbcTemplate(datasource);
//		if(jdbcObject==null)
//		{
//			System.out.println("jdbcObject null");
//		}
//	}
//	
//	public ArrayList<Items> getItems(String eventType)
//	{
//		String query = SQLQueries.DISPLAY_ITEMS;
//		ArrayList<Items> response = new ArrayList<Items>();
//		try
//		{
//			SqlRowSet result = jdbcObject.queryForRowSet(query,eventType);
//			
//			while(result.next())
//			{
//				Items item = new Items();
//				item.setItemName(result.getString("item_or_service_name"));
//				response.add(item);
//			}
//		}catch(DataAccessException e)
//		{
//			System.out.println("Unable to execute the query");
//			System.out.println(e);
//		}catch(NullPointerException e)
//		{
//			System.out.println("No such record exists");
//		}catch(Exception e)
//		{
//			System.out.println("Error in the function");
//		}
//		
//		return response;
//	}
//	
//	public ArrayList<Items> getServices(String eventType)
//	{
//		String query = SQLQueries.DISPLAY_SERVICES;
//		ArrayList<Items> response = new ArrayList<Items>();
//		try
//		{
//			SqlRowSet result = jdbcObject.queryForRowSet(query,eventType);
//			
//			while(result.next())
//			{
//				Items item = new Items();
//				item.setItemName(result.getString("item_or_service_name"));
//				response.add(item);
//			}
//		}catch(DataAccessException e)
//		{
//			System.out.println("Unable to execute the query");
//			System.out.println(e);
//		}catch(NullPointerException e)
//		{
//			System.out.println("No such record exists");
//		}catch(Exception e)
//		{
//			System.out.println("Error in the function");
//		}
//		
//		return response;
//	}
//	
//	public ArrayList<Shops> getShops(ArrayList<Items> items)
//	{
//		
//	}
//}
