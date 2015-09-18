package com.bootstrap.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootstrap.web.model.NewPCGameForm;
import com.bootstrap.web.model.NewWebGameForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@RequestMapping("/welcome")
	public String redirect() {
		return "welcome";
	}

	@RequestMapping("/newPCGame")
	public String newPCGame() {
		return "newPCGame";
	}

	@RequestMapping("/listGames")
	public String listGames() {
		return "listGames";
	}

	@RequestMapping("/newWebGame")
	public String newWebGame() {
		return "newWebGame";
	}

	@RequestMapping("/newBanner")
	public String newBanner() {
		return "newBanner";
	}

	@RequestMapping(value = "/saveWebGame", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<NewWebGameForm> update(
			@ModelAttribute("newWebGame") NewWebGameForm webGame) {

		System.out.println("obje ismi:" + webGame.getName()
				+ "Test Mode Status:" + webGame.isTest());

		return new ResponseEntity<NewWebGameForm>(webGame, HttpStatus.OK);
	}

	@RequestMapping(value = "/savePCGame", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<NewPCGameForm> updatePC(
			@ModelAttribute("newPCGame") NewPCGameForm pcGame) {

		System.out.println("obje ismi:" + pcGame.getName()
				+ " Test Mode Status:" + pcGame.isTest() +" Color: "+pcGame.getColor()+ " Turkce Metin:" + pcGame.getTurkishArea());
		
			System.out.println("ArrayList:"+pcGame.getFields());
			
		return new ResponseEntity<NewPCGameForm>(pcGame, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/savePCGame", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<NewPCGameForm> getPC(
			@ModelAttribute("newPCGame") NewPCGameForm pcGame) {
		pcGame.setColor("S12345");
		
			
		return new ResponseEntity<NewPCGameForm>(pcGame, HttpStatus.OK);
	}
}
