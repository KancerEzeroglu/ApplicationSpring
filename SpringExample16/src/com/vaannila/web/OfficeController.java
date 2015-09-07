package com.vaannila.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfficeController {

	@RequestMapping("/office.htm")
	public String redirect()
	{
		return "office";
	}
}
