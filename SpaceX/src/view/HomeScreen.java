package view;

import model.Logica;
import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen { //Travel Plans Screen
	
	private PApplet app;
	private Logica logica;
	
	static PImage marsPreview; //IMAGE FOR PAYMENT
	static PImage moonPreview; //IMAGE FOR PAYMENT
	static PImage interPreview; //IMAGE FOR PAYMENT
	
	public HomeScreen(PApplet app) {
		logica = Logica.getInstance();
		this.app = app;
		
		interPreview = app.loadImage ("PackageIntercontinental.png");
	}
	
	public void paintScreen(PImage image) {
		app.image(image, 0, 0,360,750);
		
		paintPackages();
	}
	

	public void paintPackages() {
		System.out.println("entró :c");

		for (int i = 0; i < logica.getPlanList().size(); i++) {

			System.out.println(logica.getPlanList().get(i));
			
			app.image(interPreview, 15, 340, 665/2,308/2);
			
			/**
			*logica.getPlanList().get(i).drawPlanPreview(20, 340, interPreview);
			*/ // –––––––––– couldn't make PApplet work in drawPlanPreview()
		}

	}

}
