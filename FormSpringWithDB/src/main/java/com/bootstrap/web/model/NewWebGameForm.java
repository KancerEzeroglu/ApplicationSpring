package com.bootstrap.web.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

public class NewWebGameForm {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumIm() {
		return thumIm;
	}

	public void setThumIm(String thumIm) {
		this.thumIm = thumIm;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	@NotEmpty(message = "{NotEmpty.newWebGame.name}")
	@Size(min = 5, max = 20, message = "{Size.newWebGame.name}")
	String name;

	@NotEmpty
	@URL
	String thumIm;

	@NotEmpty
	@Min(1)
	String view;

	@NotEmpty
	@URL
	String game;

	boolean test;

}
