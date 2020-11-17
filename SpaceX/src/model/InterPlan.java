package model;

import processing.core.PApplet;
import processing.core.PImage;

public class InterPlan extends TravelPlan {
	
	PImage previewImg;

	public InterPlan(String name, String info, int price, PApplet app) {
		super(name, info, price, app);
		name = "Intercontinental";
		info = "Get anywhere on Earth, faster than ever before";
		price = 2500;
	//	previewImg = app.loadImage ("./PackageIntercontinental.png");
	}
	
	public void drawPlanPreview(int posX, int posY) {
		
		getApp().image(previewImg, posX, posY, 665, 308);
		
	}

}
