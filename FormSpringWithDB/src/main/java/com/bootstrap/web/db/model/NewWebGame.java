package com.bootstrap.web.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NEWWEBGAME")
public class NewWebGame implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "THUMIM")
	private String thumIm;

	@Column(name = "VIEW")
	private String view;

	@Column(name = "GAME")
	private String game;

	@Column(name = "TEST")
	private boolean test;

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public NewWebGame(String name, String thumIm, String view, String game,
			boolean test) {
		this.name = name;
		this.thumIm = thumIm;
		this.view = view;
		this.game = game;
		this.test = test;
	}

	public NewWebGame() {

	}

}
