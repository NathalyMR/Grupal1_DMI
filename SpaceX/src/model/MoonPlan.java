package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MoonPlan extends TravelPlan {
	
	private PApplet app;

	public MoonPlan(String name, String info, int price, PApplet app) {
		super(name, info, price, app);
		name = "Moon";
		info = "7 days trip to Moon, 3 days outbound and 3 days coming back";
		price = 850000;
		
	}

}
