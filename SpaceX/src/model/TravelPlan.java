package model;

import processing.core.PApplet;
import processing.core.PImage;

public class TravelPlan {
	
	private String name, info;
	private PImage planImg;
	private int price;
	
	private PApplet app;

	public TravelPlan(String name, String info, int price, PApplet app) {
		this.name = name;
		this.info = info;
		this.price = price;
		this.app = app;
		
	}
	
	public void drawPlanPreview(PImage planImg, int posX, int posY) {
		
		app.image(planImg, posX, posY, 665, 308);
		
	}
	
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

	public PImage getPlanImg() {
		return planImg;
	}

	public void setPlanImg(PImage planImg) {
		this.planImg = planImg;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public PApplet getApp() {
		return app;
	}

	public void setApp(PApplet app) {
		this.app = app;
	}

}
