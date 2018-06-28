package com.EventArgs.Thread.Calls;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import org.springframework.jdbc.core.JdbcTemplate;

import com.EventArgs.Database.SQLQueries.ListOfQueriesForSearch;
import com.EventArgs.Model.POJOS.SearchResultsForItemShopHandler;
import com.EventArgs.Thread.Implementation.MainSearchThread;

public class MainSearchThreadCall 
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList<SearchResultsForItemShopHandler> getSearchResult(JdbcTemplate jdbcObject, String text)
	{
		ListOfQueriesForSearch queriesForSearch = new ListOfQueriesForSearch();
		FutureTask[] tasks = new FutureTask[queriesForSearch.getQueries().values().size()];
		Callable callable;
		ArrayList<SearchResultsForItemShopHandler> result = new ArrayList<>();
		
		for(int i = 0; i<tasks.length ; i++)
		{
			try
			{
				callable = new MainSearchThread(queriesForSearch.getQueries().get((ListOfQueriesForSearch.userType.values())[i]), jdbcObject, text);
				tasks[i] = new FutureTask(callable);
			}catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			Thread t = new Thread(tasks[i]);
		    t.start();
		}
		
		for(int i = 0; i<tasks.length ; i++)
		{
			try
			{
				SearchResultsForItemShopHandler eachResult = new SearchResultsForItemShopHandler();
				eachResult.setResults((ArrayList<Object>)(tasks[i].get()));	
				eachResult.setTypeOfResult(((ListOfQueriesForSearch.userType.values())[i]).toString());
				result.add(eachResult);
				
			}catch(ExecutionException e)
			{
				System.out.println("Task is aborted!!!\nTASK NUMBER :"+i);
				e.printStackTrace();
			}catch (InterruptedException e) 
			{
				System.out.println("Abe Interrupt hogaya!!!!");
			}
		}
		return result;
	}
}
