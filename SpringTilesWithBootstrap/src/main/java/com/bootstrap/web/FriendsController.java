package com.bootstrap.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FriendsController {

	@RequestMapping("/friends")
	public String redirect()
	{
		return "friends";
	}
}