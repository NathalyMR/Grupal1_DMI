package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Log in screen class 

 * @author: Juliana Cruz, Nicolás Montero

 * @version: 11/16/2020

 */
public class LogInScreen { 
	private PApplet app;
	private String[] LogInInputs;
	private ControlP5 cp5;
	private boolean email=true, password=true;
	
	public LogInScreen(PApplet app) {
		this.app = app;
		cp5 = new ControlP5(app);
		LogInInputs = new String[2];
		LogInInputs[0] = "Email";
		LogInInputs[1] = "Password";
		
		
		
	}
		
	
	public void paintTextfields(PFont labelFont) {
		cp5.addTextfield(LogInInputs[0])
		.setPosition(30, 383)
		.setSize(300, 30)
		.setAutoClear(true)
		.setColorValue(app.color(70))
		.setColorBackground(app.color(255, 255, 255, 1))
		.setFont(labelFont)
		.setColorActive(app.color(255, 255, 255, 1))
		.setColorForeground(app.color(255, 255, 255, 1))
		.setColorCursor(100)
		.getCaptionLabel().hide();
		;
		
		cp5.addTextfield(LogInInputs[1])
		.setPosition(30, 450)
		.setSize(300, 30)
		.setAutoClear(true)
		.setColorValue(app.color(70))
		.setColorBackground(app.color(255, 255, 255, 1))
		.setFont(labelFont)
		.setColorActive(app.color(255, 255, 255, 1))
		.setColorForeground(app.color(255, 255, 255, 1))
		.setColorCursor(100)
		.getCaptionLabel().hide();
		;
	} 
	
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
		app.fill(150);

		if (email==true) {
			app.text("Email", 30, 403);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 383 && app.mouseY < 403) {
				email=false;
			}
		}
		if (password==true) {
			app.text("Password", 30, 470);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 450 && app.mouseY < 480) {
				password=false;
			}
		}

	}
	
	public void clearAllFields() {
		cp5.get(Textfield.class, "Email").setText("");
		cp5.get(Textfield.class, "Password").setText("");
	}
	
}

