package view;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import model.Logica;

public class PackageScreen { // Packages Screens

	private PApplet app;
	private Logica logica;

	public PackageScreen(PApplet app) {

		logica = Logica.getInstance();
		this.app = app;

	}

	public void paintScreen(PImage image) {
		app.image(image, 0, 0, 360, 750);

	}
	
	

}
