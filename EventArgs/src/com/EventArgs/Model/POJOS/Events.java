package com.EventArgs.Model.POJOS;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//import com.fasterxml.jackson.annotation.JsonFormat;

public class Events 
{
	private long userID;
	private String eventName;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateFrom;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate dateTo;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime timeFrom;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private LocalTime timeTo;
	
	private String status;
	
	public long getUserID()
	{
		return userID;
	}
	public void setUserID(long userID) 
	{
		this.userID = userID;
	}

	public String getEventName() 
	{
		return eventName;
	}
	public void setEventName(String eventName) 
	{
		this.eventName = eventName;
	}
	
	public LocalDate getDateFrom()
	{
		return dateFrom;
	}
	public void setDateFrom(String dateFrom)
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		this.dateFrom = LocalDate.parse(dateFrom, date);
	}
	
	public LocalDate getDateTo() 
	{
		return dateTo;
	}
	public void setDateTo(String dateTo)
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd-MM-yyyy"); 
		this.dateTo = LocalDate.parse(dateTo, date);
	}
	
	public LocalTime getTimeFrom() 
	{
		return timeFrom;
	}
	public void setTimeFrom(String timeFrom)
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("HH:mm");
		this.timeFrom = LocalTime.parse(timeFrom, date);
	}
	
	public LocalTime getTimeTo()
	{
		return timeTo;
	}
	public void setTimeTo(String timeTo) 
	{
		DateTimeFormatter date = DateTimeFormatter.ofPattern("HH:mm");
		this.timeTo = LocalTime.parse(timeTo, date);
	}
	
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status)
	{
		this.status = status;
	}
}
