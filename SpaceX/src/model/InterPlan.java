package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class InterPlan extends TravelPlan {

	public InterPlan(String name, String info, int price, PApplet app) {
		super(name, info, price, app);
		name = "Intercontinental";
		info = "Get anywhere on Earth, faster than ever before";
		price = 2500;

	}

}
