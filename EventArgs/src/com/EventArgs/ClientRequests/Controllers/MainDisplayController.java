//package com.EventArgs.ClientRequests.Controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.EventArgs.Logic.Services.MainDisplayService;
//import com.EventArgs.Model.Request.MainDisplayRequest;
//import com.EventArgs.Model.Response.MainDisplayResponse;
//
//@RestController
//public class MainDisplayController 
//{
//	@Autowired
//	MainDisplayService service;
//	MainDisplayResponse response = new MainDisplayResponse();
//	
//	@RequestMapping(value = "/MainDisplayController")
//	public MainDisplayResponse get(@RequestBody MainDisplayRequest request)
//	{
//		if(service!=null)
//		{
//			response = service;
//		}
//		return response;
//	}
//}
