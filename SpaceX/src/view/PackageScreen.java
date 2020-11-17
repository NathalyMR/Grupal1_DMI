package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

import model.Logica;

public class PackageScreen { // Packages Screens

	private PApplet app;
	private Logica logica;
	public PFont bold; //ROBOTO BOLD
	public PFont light; //ROBOTO LIGHT

	public PackageScreen(PApplet app) {

		logica = Logica.getInstance();
		this.app = app;
		
		//LoadFonts----------------------------------
		bold = app.loadFont("Roboto-Bold-12.vlw");
		light = app.loadFont("Roboto-Light-12.vlw");

	}

	public void paintScreen(PImage image, int selectedPackage) {
		app.image(image, 0, 0, 360, 750);
		
		app.textMode(app.SHAPE);
		app.fill(255);
		app.textFont(light);
		app.textSize(10);
		app.text(logica.getPlanList().get(selectedPackage - 1).getInfo(), 20, 330, 320, 50);
		
		app.textFont(bold);
		app.textSize(20);
		app.text(logica.getPlanList().get(selectedPackage - 1).getName(), 20, 310);
		
		app.fill(0, 0, 70);
		app.text("$" + logica.getPlanList().get(selectedPackage - 1).getPrice() + ".oo", 20, 575);
		app.textSize(13);
		
		
		return;
	}
}
