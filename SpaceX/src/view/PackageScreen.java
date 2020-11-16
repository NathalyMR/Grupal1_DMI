package view;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import model.Logica;
import model.TravelPlan;

public class PackageScreen { //Packages Screens
	
	static PImage marsImage; //IMAGE FOR HOME
	static PImage interImage; //IMAGE FOR HOME
	static PImage moonImage; //IMAGE FOR HOME
	
	private PApplet app;
	private Logica logica;
	
	public PackageScreen(PApplet app) {
		this.app = app;
		logica.getInstance();
		
		marsImage = app.loadImage ("PackageMars.png");
		moonImage = app.loadImage ("PackageMoon.png");
		interImage = app.loadImage ("PackageIntercontinental.png");
		
	}
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
		
		
	}
	
	public void paintPackages(ArrayList<TravelPlan> ar) {
		
		logica.getPlanList();
		
		
	}
	

}
