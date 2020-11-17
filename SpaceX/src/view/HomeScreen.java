package view;

import model.Logica;
import processing.core.PApplet;
import processing.core.PImage;

public class HomeScreen { // Travel Plans Screen

	private PApplet app;
	private Logica logica;

	static PImage marsPreview; // IMAGE FOR PAYMENT
	static PImage moonPreview; // IMAGE FOR PAYMENT
	static PImage interPreview; // IMAGE FOR PAYMENT

	public HomeScreen(PApplet app) {
		logica = Logica.getInstance();
		this.app = app;

		interPreview = app.loadImage("PackageIntercontinental.png");
		moonPreview = app.loadImage("PackageMoon.png");
		marsPreview = app.loadImage("PackageMars.png");
	}

	public void paintScreen(PImage image) {
		app.image(image, 0, 0, 360, 750);

		paintPackages();
	}

	public void paintPackages() {

		int padding = 15;
		int borderTop = 240;

		// System.out.println(logica.getPlanList().get(i));

		app.imageMode(app.CENTER);
		app.image(interPreview, app.width / 2, borderTop, 665 / 2, 308 / 2);
		app.image(moonPreview, app.width / 2, (borderTop + 150 + padding), 665 / 2, 308 / 2);
		app.image(marsPreview, app.width / 2, (borderTop + 300 + padding * 2), 665 / 2, 308 / 2);

		app.imageMode(app.CORNER);

		/**
		 * Couldn't make PApplet work in drawPlanPreview() :c
		 */

		// logica.getPlanList().get(i).drawPlanPreview(20, 340, interPreview);

	}

	public int selectPlan() {

		int selection = 0;

		if (app.mouseX > 15 && app.mouseX < app.width - 15 && app.mouseY > 165 && app.mouseY < 320) {
			selection = 1;
		}

		if (app.mouseX > 15 && app.mouseX < app.width - 15 && app.mouseY > 331 && app.mouseY < 480) {
			selection = 2;
		}

		if (app.mouseX > 15 && app.mouseX < app.width - 15 && app.mouseY > 500 && app.mouseY < 650) {
			selection = 3;
		}

		return selection;

	}

}
