package view;

import processing.core.PApplet;
import processing.core.PImage;

public class PaymentScreen { //Travel Plans Screen
	private PApplet app;
	
	public PaymentScreen(PApplet app) {
		this.app = app;
		
	}
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
	}

}

