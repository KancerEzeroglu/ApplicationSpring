package com.vaannila.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome.htm")
	public String redirect()
	{
		return "welcome";
	}
}
