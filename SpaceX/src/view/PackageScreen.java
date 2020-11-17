package view;

import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

import model.Logica;
import model.TravelPlan;

public class PackageScreen { //Packages Screens
	
	private PApplet app;
	private Logica logica;
	
	public PackageScreen(PApplet app) {
		
		logica.getInstance();
		
		this.app = app;
		
	}
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
		paintPackages(logica.getPlanList());
		
		for (int i = 0; i < logica.getPlanList().size(); i++) {
			
			logica.getPlanList().get(i).drawPlanPreview(0, 340*i);
			
		}
		
	}
	
	public void paintPackages(ArrayList<TravelPlan> ar) {
		
		for (int i = 0; i < ar.size(); i++) {
			
			ar.get(i).drawPlanPreview(0, 340*i);
			
		}
		
	}

}
