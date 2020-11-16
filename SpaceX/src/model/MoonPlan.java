package model;

import processing.core.PApplet;

public class MoonPlan extends TravelPlan {

	public MoonPlan(String name, String info, int price, PApplet app) {
		super(name, info, price, app);
		name = "Moon";
	}

}
