package com.bootstrap.web.model;


public class EditGameForm {
	
String name;
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
String thumIm;
String view;
String game;
boolean test;
	
}
