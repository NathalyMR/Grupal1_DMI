package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage; 

/**
 * Register Screen class 

 * @author: Juliana Cruz, Nicolás Montero

 * @version: 11/16/2020

 */
public class RegisterScreen { 
	private PApplet app;
	private boolean name=true, lastname=true, email=true, password=true, nationality=true, cellphone=true;
	
	
	public RegisterScreen(PApplet app) {
		this.app = app;
		

	}
	
	public void paintScreen(PImage image,PFont font) {
		app.image(image, 0, 0,360,750);
		app.textFont(font);
		app.fill(150);
		
		// Labels -- must disappear to write on textfields
		if (name==true) {
			app.text("Name", 30, 200);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 180 && app.mouseY < 215) {
				name=false;
			}
		}
		if (lastname==true) {
			app.text("Last name", 30, 260);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 240 && app.mouseY < 275) {
				lastname=false;
			}
		}
		if (email==true) {
			app.text("Email", 30, 320);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 300 && app.mouseY < 335) {
				email=false;
			}
		}
		if (password==true) {
			app.text("Password", 30, 380);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 360 && app.mouseY < 395) {
				password=false;
			}
		}
		if (nationality==true) {
			app.text("Nationality", 30, 440);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 420 && app.mouseY < 455) {
				nationality=false;
			}
		}
		if (cellphone==true) {
			app.text("Cellphone", 30, 500);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 480 && app.mouseY < 515) {
				cellphone=false;
			}
		}
		

	}
	
	

}