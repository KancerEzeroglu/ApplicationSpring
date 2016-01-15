package com.bootstrap.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bootstrap.web.db.dao.EditGameDao;
import com.bootstrap.web.db.dao.NewWebGameDao;
import com.bootstrap.web.db.model.NewWebGame;
import com.bootstrap.web.model.EditGameForm;
import com.bootstrap.web.model.ListGamesForm;
import com.bootstrap.web.model.NewPCGameForm;
import com.bootstrap.web.model.NewWebGameForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	
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

		/*
		 * // test etmek amaciyla her seferinde yeni bir data girmeyelim diye
		 * eklendi. NewWebGame nwg = new NewWebGame(); nwg.setGame("asd");
		 * nwg.setName("dfsfs"); nwg.setTest(false); nwg.setThumIm("sda");
		 * nwg.setView("asfd"); newWebGameDao.create(nwg);
		 */

		// Tabloda DB'den gelen verileri listelemek icin kullanildi.
		// PostgreSql'e gectigimiz icin bu kisim kullanilmayacak.
		/*
		 * ArrayList<NewWebGame> nwg3 = (ArrayList<NewWebGame>)
		 * newWebGameDao.getAll(); //ArrayList<NewWebGame> nwg3 =
		 * (ArrayList<NewWebGame>) newWebGameDao.search("yavuz");
		 * modelWeb.addAttribute("newWebGame_o", nwg3);
		 */

		return "listGames";
	}

	@RequestMapping(value = "/searchGames", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public ResponseEntity<ArrayList<NewWebGame>> searchGames(
			@ModelAttribute("listGames") ListGamesForm listgames) {

		/*
		 * System.out.println("ListGame game name:" + listgames.getName() +
		 * "ListGame game date: " + listgames.getDatepickerDate());
		 */
		ArrayList<NewWebGame> nwg3 = (ArrayList<NewWebGame>) newWebGameDao
				.search(listgames.getName(), listgames.getDate());
		return new ResponseEntity<ArrayList<NewWebGame>>(nwg3, HttpStatus.OK);

	}

	@Secured({"ROLE_ADMIN"})
	@RequestMapping("/newWebGame")
	public String newWebGame() {

		/*
		 * // test etme amaciyla eklendi. NewWebGame sekmesine gelindiginde
		 * asagidaki parametreler set edilir Customer cus = new Customer();
		 * cus.setEmail("kancer@mail.com"); cus.setFirstName("kancer");
		 * cus.setLastName("gökırmak");
		 * 
		 * customerDao.create(cus);
		 * 
		 * ArrayList<Customer> cus2 = (ArrayList<Customer>)
		 * customerDao.getAll();
		 * 
		 * for (int i = 0; i < cus2.size(); i++) {
		 * System.out.println(cus2.get(i).getEmail()); }
		 */

		return "newWebGame";
	}

	@RequestMapping("/newBanner")
	public String newBanner() {
		return "newBanner";
	}

	@RequestMapping(value = "/listGames/edit/{gameId}", method = RequestMethod.GET)
	public String editGame(@PathVariable int gameId, Model modelEditGame) {

		modelEditGame.addAttribute("game", editGameDao.getByKey(gameId)); // game
																			// isimli
																			// attribute'e
																			// objenin
																			// tüm
																			// özellikleri
																			// atanır.

		return "editGame";
	}

	@RequestMapping(value = "/saveWebGame", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<?> saveWebGame(
			@ModelAttribute("newWebGame") @Valid NewWebGameForm webGame,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ResponseEntity(result.getAllErrors(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
		System.out.println("obje ismi:" + webGame.getName()
				+ "Test Mode Status:" + webGame.isTest());

		// get current Date

		/* DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy"); */
		Date date = new Date();

		// save to DB
		NewWebGame nwg = new NewWebGame();
		nwg.setName(webGame.getName());
		nwg.setGame(webGame.getGame());
		nwg.setThumIm(webGame.getThumIm());
		nwg.setView(webGame.getView());
		nwg.setTest(webGame.isTest());
		nwg.setDate(date);

		newWebGameDao.create(nwg);

		// end save to DB

		// check data form DB

		/*
		 * ArrayList<NewWebGame> nwg2 = (ArrayList<NewWebGame>)
		 * newWebGameDao.getAll();
		 */
		// test etmek amaciyla konsola istedigimiz datayi bastirdik. DB'ye
		// kayit olmus mu kontrol ettik.
		/*
		 * for (int i = 0; i < nwg2.size(); i++) {
		 * System.out.println(nwg2.get(i).getDate()); }
		 */

		return new ResponseEntity<NewWebGameForm>(webGame, HttpStatus.OK);
	}

	@RequestMapping(value = "/savePCGame", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE
			+ "; charset=utf-8" })
	public @ResponseBody ResponseEntity<NewPCGameForm> savePCGame(
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
			@ModelAttribute("game") EditGameForm updateWebGame,
			@PathVariable int gameId_up) {

		// DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
		Date date = new Date();

		NewWebGame nwg_up = editGameDao.getByKey(gameId_up);

		nwg_up.setName(updateWebGame.getName());
		nwg_up.setGame(updateWebGame.getGame());
		nwg_up.setThumIm(updateWebGame.getThumIm());
		nwg_up.setView(updateWebGame.getView());
		nwg_up.setTest(updateWebGame.isTest());
		nwg_up.setDate(date);

		editGameDao.update(nwg_up);

		return new ResponseEntity<EditGameForm>(updateWebGame, HttpStatus.OK);
	}

	@RequestMapping(value = "/listGames/delete/{gameId_del}", method = RequestMethod.GET)
	public String deleteWebGame(@PathVariable int gameId_del) {

		newWebGameDao.deleteByKey(gameId_del);
		return "listGames";
	}

	@RequestMapping(value = "/download/sampleCsvFile")
	public void downloadSampleCSVFile(HttpServletResponse response)
			throws IOException {
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition",
				"attachment; filename=\"gamelist.csv\"");

		List<NewWebGame> gamesList = (List<NewWebGame>) newWebGameDao.getAll();
		// PrintWriter writer = response.getWriter();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

		ArrayList<String> rows = new ArrayList<String>();
		rows.add("Name,Created Date");
		rows.add("\n");

		HashMap gameHashName = new HashMap();

		for (NewWebGame nwg : gamesList) {
			gameHashName.put(nwg.getId(), nwg.getName());

		}
		HashMap gameHashDate = new HashMap();

		for (NewWebGame nwg2 : gamesList) {
			gameHashDate.put(nwg2.getId(), nwg2.getDate());
		}

		Set set = gameHashName.entrySet();
		Set set2 = gameHashDate.entrySet();

		Iterator i = set.iterator();
		Iterator i2 = set2.iterator();

		while (i.hasNext()) {
			Map.Entry me = (Map.Entry) i.next();
			Map.Entry me2 = (Map.Entry) i2.next();

			rows.add(me.getKey().toString() + ",");
			rows.add(me.getValue().toString() + ",");
			rows.add(df.format(me2.getValue()));
			rows.add("\n");
		}

		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}

		response.getOutputStream().flush();

		// icerisinde C1410.. yazan bir CSV dosyasi indirir.
		// PrintWriter writer = response.getWriter();
		// writer.println("C14107153");

	}

	// to download Excel
	@RequestMapping(value = "/download/sampleExcelFile")
	public ModelAndView downloadSampleExcelFile() {
		List<NewWebGame> gamesListExcel = (List<NewWebGame>) newWebGameDao
				.getAll();
		return new ModelAndView("excelView", "gamesListExcel", gamesListExcel);
	}

	// to download PDF
	@RequestMapping(value = "/download/samplePDFFile")
	public ModelAndView downloadSamplePDFFile() {
		List<NewWebGame> gamesListPDF = (List<NewWebGame>) newWebGameDao
				.getAll();
		return new ModelAndView("pdfView", "gamesListPDF", gamesListPDF);
	}

	// for Spring Security
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model) {
		return "logout";
	}

	// end Spring Security
}
