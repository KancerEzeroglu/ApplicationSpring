package model;

import java.util.ArrayList;

public class Student {

	String name;
	String surname;
	Integer age;
	String address;
	ArrayList<String> lessons = new ArrayList<String>();
	String department;
	ArrayList<String> friends = new ArrayList<String>();
	
	public void setName(String name){
		this.name= name;
	}
	public String getName(){
		return name;
	}
	public void setSurname(String surname){
		this.surname = surname;
	}
	public String getSurname(){
		return surname;
	}
	public void setAge(Integer age){
		this.age = age;
	}
	public Integer getAge(){
		return age;
	}
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment(){
		return department;
	}
	public void addLessons(String les){
		lessons.add(les);
	}
	public ArrayList<String> getLessons(){
		return lessons;
	}
	public void addFriends(String fri){
		friends.add(fri);
	}
	public ArrayList<String> getFriends(){
		return friends;
	}
}
