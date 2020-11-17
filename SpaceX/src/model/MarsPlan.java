package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MarsPlan extends TravelPlan {

	public MarsPlan(String name, String info, int price, PApplet app) {
		super("Mars", "1 year trip to Mars, 6 months outbound and 6 months coming back"
				+ "It takes place at the time of year when Earth and Mars are closest.", 8000000, app);

	}

}
