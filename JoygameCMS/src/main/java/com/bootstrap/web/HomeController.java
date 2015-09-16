package com.bootstrap.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@RequestMapping("/welcome")
	public String redirect()
	{
		return "welcome";
	}
	
	@RequestMapping("/newPCGame")
	public String newPCGame()
	{
		return "newPCGame";
	}
	@RequestMapping("/listGames")
	public String listGames()
	{
		return "listGames";
	}
	@RequestMapping("/newWebGame")
	public String newWebGame()
	{
		return "newWebGame";
	}
	@RequestMapping("/newBanner")
	public String newBanner()
	{
		return "newBanner";
	}
	
}
