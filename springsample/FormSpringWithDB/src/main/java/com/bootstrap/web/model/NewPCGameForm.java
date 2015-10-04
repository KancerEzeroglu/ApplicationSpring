package com.bootstrap.web.model;

import java.util.ArrayList;

public class NewPCGameForm {

	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCdn_url() {
		return cdn_url;
	}
	public void setCdn_url(String cdn_url) {
		this.cdn_url = cdn_url;
	}
	public String getBgn_url() {
		return bgn_url;
	}
	public void setBgn_url(String bgn_url) {
		this.bgn_url = bgn_url;
	}
	public String getTml_url() {
		return tml_url;
	}
	public void setTml_url(String tml_url) {
		this.tml_url = tml_url;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTurkishArea() {
		return turkishArea;
	}
	public void setTurkishArea(String turkishArea) {
		this.turkishArea = turkishArea;
	}
	public String getEnglishArea() {
		return englishArea;
	}
	public void setEnglishArea(String englishArea) {
		this.englishArea = englishArea;
	}
	public String getArabicArea() {
		return arabicArea;
	}
	public void setArabicArea(String arabicArea) {
		this.arabicArea = arabicArea;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public boolean isTest() {
		return test;
	}
	public void setTest(boolean test) {
		this.test = test;
	}
	public String getViewOrder() {
		return viewOrder;
	}
	public void setViewOrder(String viewOrder) {
		this.viewOrder = viewOrder;
	}
	public String getInsDic() {
		return insDic;
	}
	public void setInsDic(String insDic) {
		this.insDic = insDic;
	}
	public String getRegKey() {
		return regKey;
	}
	public void setRegKey(String regKey) {
		this.regKey = regKey;
	}
	public String getLaExPath() {
		return laExPath;
	}
	public void setLaExPath(String laExPath) {
		this.laExPath = laExPath;
	}
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	public String getGoogle() {
		return google;
	}
	public void setGoogle(String google) {
		this.google = google;
	}
	String cdn_url;
	String bgn_url;
	String tml_url;
	String color;
	String turkishArea;
	String englishArea;
	String arabicArea;
	String video;
	boolean test;
	String viewOrder;
	String insDic;
	String regKey;
	String laExPath;
	String twitter;
	String facebook;
	String youtube;
	String google;
	ArrayList<String> fields = new ArrayList<String>();
	public ArrayList<String> getFields() {
		return fields;
	}
	public void setFields(ArrayList<String> fields) {
		this.fields = fields;
	}
	   
}
