package view;

import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen { //Travel Plans Screen
	private PApplet app;
	
	public HomeScreen(PApplet app) {
		this.app = app;
		
	}
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
	}

}
