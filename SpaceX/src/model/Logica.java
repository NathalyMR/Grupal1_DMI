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

		getPlanList().add(moonPlan);
		getPlanList().add(interPlan);
		getPlanList().add(marsPlan);

	}

	public ArrayList<TravelPlan> getPlanList() {

		return travelPlanList;

	}

	public void createUser() {

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
