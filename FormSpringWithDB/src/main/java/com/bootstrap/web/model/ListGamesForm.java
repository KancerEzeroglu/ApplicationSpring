package com.bootstrap.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class ListGamesForm {

	String name;
	@DateTimeFormat(pattern="MM-dd-yyyy")
	Date date;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
