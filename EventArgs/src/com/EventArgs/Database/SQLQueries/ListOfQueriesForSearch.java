package com.EventArgs.Database.SQLQueries;

import java.util.HashMap;
import java.util.Map;

public class ListOfQueriesForSearch extends SQLQueries
{
	public static enum userType
    {
		ITEMS,
        SHOPS,
        EVENT_HANDLERS,
        SERVICE,
        VENUE
    }
	
	private Map<userType,String> queries = new HashMap<userType,String>();
	
	public ListOfQueriesForSearch()
	{
		setQueries();
	}

	public Map<userType, String> getQueries() 
	{
		return queries;
	}
	
	public void setQueries()
	{
		queries.put(userType.ITEMS, SEARCH_ITEMS);
		queries.put(userType.SHOPS, SEARCH_SHOPS);
		queries.put(userType.EVENT_HANDLERS, SEARCH_EVENT_HANDLERS);
		queries.put(userType.SERVICE, SEARCH_SERVICES);
		queries.put(userType.VENUE, SEARCH_VENUES);
	}
}
