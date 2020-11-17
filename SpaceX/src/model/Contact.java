package model;

import processing.core.PApplet;

public class Contact implements Comparable <Contact>{
	
	private String name, lastName, email, nationality;
	private int phoneNumber, age;
	
	private PApplet app;

	public Contact(String name, String lastName, String email, String nationality, int age, int phoneNumber, PApplet app) {
		this.app = app;
		this.lastName= lastName;
		this.name = name;
		this.email = email;
		this.nationality = nationality;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
	
	@Override
	public int compareTo(Contact o) {
		return getName().compareTo(o.getName());

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

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
