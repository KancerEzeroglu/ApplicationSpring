package com.bootstrap.web;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bootstrap.web.db.dao.CustomerDao;
import com.bootstrap.web.db.dao.EditGameDao;
import com.bootstrap.web.db.dao.NewWebGameDao;
import com.bootstrap.web.db.model.Customer;
import com.bootstrap.web.db.model.NewWebGame;
import com.bootstrap.web.model.DeleteGameForm;
import com.bootstrap.web.model.EditGameForm;
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
	@Autowired
	protected EditGameDao editGameDao;
	
	@RequestMapping("/welcome")
	public String redirect() {
		return "welcome";
	}

	@RequestMapping("/newPCGame")
	public String newPCGame() {
		return "newPCGame";
	}

	@RequestMapping("/listGames")
	public String listGames(Model modelWeb) {
		
		/*// test etmek amaciyla her seferinde yeni bir data girmeyelim diye eklendi.
		NewWebGame nwg = new NewWebGame();
		nwg.setGame("asd");
		nwg.setName("dfsfs");
		nwg.setTest(false);
		nwg.setThumIm("sda");
		nwg.setView("asfd");
		newWebGameDao.create(nwg);*/
		
		//Tabloda DB'den gelen verileri listelemek icin kullanildi.
		ArrayList<NewWebGame> nwg3 = (ArrayList<NewWebGame>) newWebGameDao.getAll();
		modelWeb.addAttribute("newWebGame_o",nwg3);
		
		return "listGames";
	}

	@RequestMapping("/newWebGame")
	public String newWebGame() {

		/*// test etme amaciyla eklendi. NewWebGame sekmesine gelindiginde asagidaki parametreler set edilir
		Customer cus = new Customer();
		cus.setEmail("kancer@mail.com");
		cus.setFirstName("kancer");
		cus.setLastName("gökırmak");

		customerDao.create(cus);

		ArrayList<Customer> cus2 = (ArrayList<Customer>) customerDao.getAll();

		for (int i = 0; i < cus2.size(); i++) {
			System.out.println(cus2.get(i).getEmail());
		}*/
		
		
		
		return "newWebGame";
	}

	@RequestMapping("/newBanner")
	public String newBanner() {
		return "newBanner";
	}
	
	@RequestMapping(value = "/listGames/edit/{gameId}", method = RequestMethod.GET)
	public String editGame(@PathVariable int gameId, Model modelEditGame) {
	
		modelEditGame.addAttribute("game",editGameDao.getByKey(gameId)); // game isimli attribute'e objenin tüm özellikleri atanır.
		
		return "editGame";
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

		// test etmek amaciyla konsola istedigimiz datayi bastirdik. DB'ye kayit olmus mu kontrol ettik.
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
	
	@RequestMapping(value = "/listGames/edit/{gameId_up}", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<EditGameForm> updateWebGame(
			@ModelAttribute("game") EditGameForm updateWebGame, @PathVariable int gameId_up) {
	
		NewWebGame nwg_up = editGameDao.getByKey(gameId_up);
		
		nwg_up.setName(updateWebGame.getName());
		nwg_up.setGame(updateWebGame.getGame());
		nwg_up.setThumIm(updateWebGame.getThumIm());
		nwg_up.setView(updateWebGame.getView());
		nwg_up.setTest(updateWebGame.isTest());
		
		editGameDao.update(nwg_up);
		
		return new ResponseEntity<EditGameForm>(updateWebGame, HttpStatus.OK);
	}
	@RequestMapping(value = "/listGames/delete/{gameId_del}", method = RequestMethod.GET)
	public @ResponseBody String deleteWebGame(@PathVariable int gameId_del) {
	
		newWebGameDao.deleteByKey(gameId_del);
		
		return "listGames";
	}

}
