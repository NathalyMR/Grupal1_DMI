package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	public ArrayList<User> userList;
	public ArrayList<TravelPlan> travelPlanList;

	private static Logica logicInstance;

	public TravelPlan moonPlan, interPlan, marsPlan;

	private PApplet app;

	private Logica() {

		this.app = new PApplet();
		initializeTravelPlanList();

	}

	public static Logica getInstance() {

		if (logicInstance == null) {
			logicInstance = new Logica();
		}

		return logicInstance;
	}

	public void initializeUserList() {

		userList = new ArrayList<User>();

	}

	public void initializeTravelPlanList() {

		travelPlanList = new ArrayList<TravelPlan>();

		moonPlan = new MoonPlan(null, null, 0, app);
		interPlan = new InterPlan(null, null, 0, app);
		marsPlan = new MarsPlan(null, null, 0, app);

		getPlanList().add(interPlan);
		getPlanList().add(moonPlan);
		getPlanList().add(marsPlan);

	}

	public ArrayList<TravelPlan> getPlanList() {

		return travelPlanList;

	}

	public void createUser(String name, String lastname, String email, String password, String nationality,
			int cellphone) {
		User newUser = new User(name, lastname, email, password, nationality, cellphone, app);
		userList.add(newUser);

		for (int i = 0; i < userList.size(); i++) {
			System.out.println(userList.get(i).getName());
			System.out.println(userList.get(i).getLastName());
			System.out.println(userList.get(i).getEmail());
			System.out.println(userList.get(i).getPassword());
			System.out.println(userList.get(i).getNationality());
			System.out.println(userList.get(i).getPhoneNumber());
			System.out.println(">>>>>>>>><<<<<<<<<<");
		}
	}

	public void buyTravelPlan() {

	}

	public void addContact() {

	}

	public void logIn() {

	}

	/*
	 * public void logOut() {
	 * 
	 * 
	 * }
	 */

}
