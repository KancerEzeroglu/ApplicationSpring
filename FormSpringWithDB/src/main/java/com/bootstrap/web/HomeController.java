package com.bootstrap.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootstrap.web.db.dao.CustomerDao;
import com.bootstrap.web.db.dao.NewWebGameDao;
import com.bootstrap.web.db.model.Customer;
import com.bootstrap.web.db.model.NewWebGame;
import com.bootstrap.web.model.NewPCGameForm;
import com.bootstrap.web.model.NewWebGameForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	protected CustomerDao customerDao;
	@Autowired
	protected NewWebGameDao newWebGameDao;

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

		Customer cus = new Customer();
		cus.setEmail("kancer@mail.com");
		cus.setFirstName("kancer");
		cus.setLastName("gökırmak");

		customerDao.create(cus);

		ArrayList<Customer> cus2 = (ArrayList<Customer>) customerDao.getAll();

		for (int i = 0; i < cus2.size(); i++) {
			System.out.println(cus2.get(i).getEmail());
		}
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

		// save to DB
		NewWebGame nwg = new NewWebGame();
		nwg.setName(webGame.getName());
		nwg.setGame(webGame.getGame());
		nwg.setThumIm(webGame.getThumIm());
		nwg.setView(webGame.getView());
		nwg.setTest(webGame.isTest());

		newWebGameDao.create(nwg);

		// end save to DB
		
		//check data form DB
		ArrayList<NewWebGame> nwg2 = (ArrayList<NewWebGame>) newWebGameDao.getAll();

		for (int i = 0; i < nwg2.size(); i++) {
			System.out.println(nwg2.get(i).getGame());
		}

		
		return new ResponseEntity<NewWebGameForm>(webGame, HttpStatus.OK);
	}

	@RequestMapping(value = "/savePCGame", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<NewPCGameForm> updatePC(
			@ModelAttribute("newPCGame") NewPCGameForm pcGame) {

		System.out.println("obje ismi:" + pcGame.getName()
				+ " Test Mode Status:" + pcGame.isTest() + " Color: "
				+ pcGame.getColor() + " Turkce Metin:"
				+ pcGame.getTurkishArea());

		System.out.println("ArrayList:" + pcGame.getFields());

		return new ResponseEntity<NewPCGameForm>(pcGame, HttpStatus.OK);
	}

}
