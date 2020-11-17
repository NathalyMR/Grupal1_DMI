package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MoonPlan extends TravelPlan {
	
	private PApplet app;

	public MoonPlan(String name, String info, int price, PApplet app) {
		super("Moon", "7 days trip to Moon, 3 days outbound and 3 days coming back", 850000, app);
		
	}

}
