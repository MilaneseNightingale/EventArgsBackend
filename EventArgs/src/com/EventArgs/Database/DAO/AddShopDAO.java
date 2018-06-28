package com.EventArgs.Database.DAO;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.EventArgs.Database.SQLQueries.SQLQueries;
import com.EventArgs.Model.POJOS.Shops;

public class AddShopDAO 
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
	
	public boolean addShop(Shops shop)
	{
		String queryToAddShop = SQLQueries.ADD_SHOP;
		try
		{
			int i = jdbcObject.update(queryToAddShop, shop.getShopName(),shop.getAddressID(),shop.getShopRegID(),shop.getShopPhNo(),shop.getShopEmailID(),shop.getShopPictures());
			if(i!=0)
			{
				return true;
			}
		}catch(DataAccessException e)
		{
			System.out.println("Error in inserting shop");
			e.printStackTrace();
		}
		return false;
	}
}
