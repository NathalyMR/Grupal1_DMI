package model;

import processing.core.PApplet;
import processing.core.PImage;

public class MarsPlan extends TravelPlan {
	
	PImage previewImg;

	public MarsPlan(String name, String info, int price, PApplet app) {
		super(name, info, price, app);
		name = "Mars";
		info = "1 year trip to Mars, 6 months outbound and 6 months coming back"
				+ "It takes place at the time of year when Earth and Mars are closest.";
		price = 8000000;
		//this.previewImg = app.loadImage ("PackageMars.png");
	}
	
	public void drawPlanPreview(int posX, int posY) {
		
		getApp().image(this.previewImg, posX, posY, 665, 308);
		
	}

}
