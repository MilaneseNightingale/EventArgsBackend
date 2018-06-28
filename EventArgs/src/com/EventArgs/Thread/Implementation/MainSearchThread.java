package com.EventArgs.Thread.Implementation;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.EventArgs.Model.POJOS.SearchResult;

public class MainSearchThread implements Callable<ArrayList<SearchResult>>
{
	private String query;
	private JdbcTemplate jdbcObject;
	private String text;

	public MainSearchThread(String query,JdbcTemplate jdbcObject,String text)
	{
		this.query = query;
		this.jdbcObject = jdbcObject; 
		this.text = text;
	}

	@Override
	public ArrayList<SearchResult> call() throws Exception 
	{
		query = query.replace("?",text);
		ArrayList<SearchResult> returnResult = new ArrayList<>();
		try
		{
			SqlRowSet result = jdbcObject.queryForRowSet(query);
			
			while(result.next())
			{
				SearchResult searchResult = new SearchResult();
				
				searchResult.setName(result.getString("name"));
				returnResult.add(searchResult);
			}
			
		}catch(DataAccessException e)
		{
			System.out.println("Unable to execute the query");
			System.out.println(e);
		}catch(NullPointerException e)
		{
			System.out.println("Honey its a NULL in ItemsThreadClass!!");
		}catch(Exception e)
		{
			System.out.println("Error in the function");
		}
		return returnResult;
	}
}
