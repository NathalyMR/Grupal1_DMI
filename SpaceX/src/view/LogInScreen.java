package view;

import processing.core.PApplet;
import processing.core.PImage;

public class LogInScreen { //Log In Screen
	private PApplet app;
	
	public LogInScreen(PApplet app) {
		this.app = app;
		
	}
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
	}

	
}

