package com.EventArgs.Database.SQLQueries;

public class SQLQueries
{
	//Register User
	public static final String CHECK_FOR_USER_EXISTENCE = "SELECT user_id FROM eventargs.users WHERE user_email = ?";
	public static final String REGISTER_USER = "INSERT INTO eventargs.users"
											 + "(user_firstname,user_lastname,user_phno,user_password,user_email,user_dob)"
											 + " VALUES (?,?,?,?,?,?)";
	
	//Register Shop Owner
	public static final String ADD_SHOP_OWNER = "INSERT INTO eventargs.owners"
											  + "(user_id,owner_aadhar_no,owner_reg_id)"
											  + " VALUES (?,?,?)";
	
	//Register Venue Manager
	public static final String ADD_VENUE_MANAGER = "INSERT INTO eventargs.venue_manager"
												 + "(user_id,vmanager_aadhar_no,vmanager_reg_id)"
												 + " VALUES (?,?,?)";	
	//Main Event Types
	public static final String GET_MAIN_EVENT_TYPES = "SELECT eventtype_name FROM eventargs.event_types WHERE eventtype_level = \'A\' ORDER BY eventtype_id";
	public static final String GET_MAINTYPES_IMAGES = "SELECT eventtype_image_link FROM eventargs.event_types WHERE eventtype_level = \'A\' ORDER BY eventtype_id";
	
	//Sub Event Types
	public static final String GET_SUB_EVENT_TYPES = "SELECT eventtype_name FROM eventargs.event_types WHERE event_types.eventtype_id IN" + 
													 "(" + 
													 "    SELECT subeventtype_id " + 
													 "    FROM event_types INNER JOIN relation_between_eventtypes " + 
													 "    ON maineventtype_id = eventtype_id " + 
													 "    WHERE eventtype_name = ? " + 
													 ")";
	
	//Create New events
	public static final String CREATE_NEW_EVENT = "INSERT INTO eventargs.events"
												+ "(event_name,date_from,date_to,time_from,time_to,user_id,event_status)"
												+ " VALUES(?,?,?,?,?,?,?) ";
	
	//My Events
	public static final String GET_MY_EVENTS = "SELECT * FROM eventargs.events WHERE user_id = ?";
	
	//Add Shop
	public static final String ADD_SHOP = "INSERT INTO eventargs.shops"
										+ "(shop_name,shop_address_id,shop_reg_id,shop_phone_number,shop_emailid,shop_picture) "
										+ "VALUES (?, ?, ?, ?, ?, ?)";
	
	//VALIDATION QUERIES
	public static final String VALIDATE_SHOP_OWNER_REQUESTS = "SELECT 1 FROM eventargs.owners WHERE owner_id = ?";
	public static final String VALIDATE_USER_REQUESTS = "SELECT 1 FROM eventargs.users WHERE user_id = 1";
	
	//Add Addresses for USER
	public static final String CHECK_ADDRESS_EXISTENCE = "SELECT address_id FROM eventargs.addresses WHERE longitude LIKE ? AND latitude LIKE ?";
	public static final String ADD_USER_ADDRESS = "INSERT INTO eventargs.user_addresses"
												+ "(user_id,address_id,addresstype_for_user) "
												+ "VALUES(?,?,?)";
	public static final String ADD_ADDRESS = "INSERT INTO eventargs.addresses"
										   + "(address_name,longitude,latitude)"
										   + " VALUES(?,?,?)";
	public static final String CHECK_STREET_ADDRESS = "SELECT address_id FROM eventargs.addresses WHERE street = ?";
	public static final String ADD_ADDRESS_TEXT = "INSERT INTO eventargs.addresses"
												+ "(address_name,street,locality,city,zipcode,state)"
												+ " VALUES(?,?,?,?,?,?)";
	
	//Login
	public static final String CHECK_LOGIN_DETAILS = "SELECT user_id FROM eventargs.users WHERE user_email = ? and user_password = ?";
	public static final String GET_SHOP_OWNER_ID = "SELECT owner_id FROM eventargs.owners WHERE user_id = ?";
	public static final String GET_VENUE_MANAGER_ID = "SELECT vmanager_id FROM eventargs.venue_manager WHERE user_id = ?";
	
	//Search
	//MainEventTypes and SubEventTypes
	public static final String SEARCH_EVENTTYPES = "SELECT eventtype_name,eventtype_level FROM eventargs.event_types"
												 + " WHERE eventtype_name LIKE \'%?%\'";	
	//Items, Shops and 	EventHandlers
	public static final String SEARCH_ITEMS = "SELECT item_or_service_name AS name FROM eventargs.items_or_services"
											+ " WHERE item_or_service_name LIKE \'%?%\'"
											+ " AND item_or_service_type = \'ITEM\'";
	public static final String SEARCH_SHOPS = "SELECT shop_name AS name FROM eventargs.shops"
											+ " WHERE shop_name LIKE \'%?%\'";
	public static final String SEARCH_EVENT_HANDLERS = "SELECT event_handler_name AS name FROM eventargs.event_handlers"
													 + " WHERE event_handler_name LIKE \'%?%\'";
	public static final String SEARCH_SERVICES = "SELECT item_or_service_name AS name FROM eventargs.items_or_services"
											   + " WHERE item_or_service_name LIKE \'%?%\'"
											   + " AND item_or_service_type = \'SERVICE\'";
	public static final String SEARCH_VENUES = "SELECT venue_name AS name FROM eventargs.venues"
											 + " WHERE venue_name LIKE \'%?%\'";
	
	//Main Display Queries
	//ITEMS
	public static final String DISPLAY_ITEMS = "SELECT item_or_service_name FROM eventargs.items_or_services"
											 + " WHERE item_or_service_id IN ("
											 							   	  + "SELECT item_or_service_id FROM eventargs.event_item_services"
											 							   	  + " WHERE eventtype_id IN ("
											 							   	  							+ "SELECT eventtype_id FROM eventargs.event_types"
											 							   	  							+ " WHERE eventtype_name = ?"
											 							   	  						 + ")"
											 							   + ")"
											 + " AND item_or_service_type = \'ITEM\'";
	//SERVICES
	public static final String DISPLAY_SERVICES = "SELECT item_or_service_name FROM eventargs.items_or_services"
												+ " WHERE item_or_service_id IN ("
																				+ "SELECT item_or_service_id FROM eventargs.event_item_services"
																				+ " WHERE eventtype_id IN ("
																											+ "SELECT eventtype_id FROM eventargs.event_types"
																											+ " WHERE eventtype_name = ?"
																										+ ")"
																				+ ")"
												+ " AND item_or_service_type = \'SERVICE\'";
}
