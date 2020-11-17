package view;

import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen { //Travel Plans Screen
	private PApplet app;
	
	public HomeScreen(PApplet app) {
		this.app = app;
		
	}
	
	public void paintImage(PImage image,int x,int y,int w, int h) {
		app.image(image, x, y, w, h);
	}
	
}
