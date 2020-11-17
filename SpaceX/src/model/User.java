package model;

import processing.core.PApplet;

public class User {
	
	private String name, lastName, email, nationality, password;
	private int phoneNumber;
	
	private PApplet app;

	public User(String name, String lastName, String email, String nationality, String password, int phoneNumber, PApplet app) {
		this.app = app;
		this.lastName= lastName;
		this.name = name;
		this.email = email;
		this.nationality = nationality;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public PApplet getApp() {
		return app;
	}


	public void setApp(PApplet app) {
		this.app = app;
	}

}
