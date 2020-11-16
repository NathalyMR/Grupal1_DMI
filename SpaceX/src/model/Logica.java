package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logica {

	public ArrayList<User> userList;
	public ArrayList<TravelPlan> travelPlanList;

	private static Logica logicInstance;

	public TravelPlan moonPlan, interPlan, marsPlan;
	
	static PApplet app;
	
	private Logica(PApplet app) {
		
		Logica.app = app;

	}

	public static Logica getInstance() {

		if (logicInstance == null) {
			logicInstance = new Logica(app);
		}

		return logicInstance;
	}

	public void initializeUserList() {

		userList = new ArrayList<User>();

	}

	public void initializeTravelPlanList() {

		travelPlanList = new ArrayList<TravelPlan>();

		moonPlan = new MoonPlan("Moon", "7 days trip to Moon, 3 days outbound and 3 days coming back", 850000,
				app);

		interPlan = new InterPlan("Intercontinental", "Get anywhere on Earth, faster than ever before", 2500,
				app);

		marsPlan = new MarsPlan("Mars",
				"1 year trip to Mars, 6 months outbound and 6 months coming back"
						+ "It takes place at the time of year when Earth and Mars are closest.",
				8000000, app);

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
