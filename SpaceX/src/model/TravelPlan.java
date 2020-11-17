package model;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class TravelPlan {
	
	protected PApplet app;
	
	private String name;
	private String info;
	private int price;

	public TravelPlan(String name, String info, int price, PApplet app) {
		this.app = app;
		this.name = name;
		this.info = info;
		this.price = price;
		
	}
	
	/*public void drawPlanPreview(int posX, int posY, PImage image) {
		
		app.imageMode(PConstants.CENTER);
		app.image(image, app.width/2, posY, 665, 308);
		app.imageMode(PConstants.CORNER);
		
	}*/ // –––––––––– couldn't make PApplet work 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
