package model;

import processing.core.PApplet;
import processing.core.PImage;

public class MoonPlan extends TravelPlan {
	
	PImage previewImg;
	PApplet app;

	public MoonPlan(String name, String info, int price, PApplet app) {
		super(name, info, price, app);
		this.app = app;
		name = "Moon";
		info = "7 days trip to Moon, 3 days outbound and 3 days coming back";
		price = 850000;
		
		this.previewImg = app.loadImage("../data/PackageMoon.png");
		
	}

	public void drawPlanPreview(int posX, int posY) {
		
		app.image(this.previewImg, posX, posY, 665, 308);

	}

}
