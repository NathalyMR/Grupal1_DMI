package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import model.Logica;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class PaymentScreen { // Payment Screen
	private PApplet app;
	private boolean showNameInCard = true, showNumber = true, showDate = true, showSecurityCode = true;
	private String name, number, date, securityCode;

	private ControlP5 cp5;
	private String[] paymentInputs;
	public boolean accepted = false;

	private Logica logica;

	public PFont bold; // ROBOTO BOLD
	public PFont light; // ROBOTO LIGHT

	static PImage marsPay, moonPay, interPay; // IMAGE FOR PAYMENT

	public PaymentScreen(PApplet app) {
		logica = Logica.getInstance();
		this.app = app;
		cp5 = new ControlP5(app);
		paymentInputs = new String[4];

		moonPay = app.loadImage("PayMoon.png");
		marsPay = app.loadImage("PayMars.png");
		interPay = app.loadImage("PayIntercontinental.png");

		bold = app.loadFont("Roboto-Bold-12.vlw");
		light = app.loadFont("Roboto-Light-12.vlw");

	}

	public void paintTextfields(PFont font) {

		paymentInputs[0] = "Cardholder�s name";
		paymentInputs[1] = "Card number";
		paymentInputs[2] = "Expiry date (MM/YY)";
		paymentInputs[3] = "Security code";

		for (int i = 0; i < paymentInputs.length; i++) {

			cp5.addTextfield(paymentInputs[i]).setPosition(22, 355 + (i * 55)).setSize(300, 30).setAutoClear(true)
					.setColorValue(app.color(70)).setColorBackground(app.color(255, 255, 255, 1)).setFont(font)
					.setColorActive(app.color(255, 255, 255, 1)).setColorForeground(app.color(255, 255, 255, 1))
					.setColorCursor(100).getCaptionLabel().hide();
			;
		}

	}

	public void paintScreen(PImage image, int selectedPackage) {
		app.image(image, 0, 0, 360, 750);
		
		// Image and info according to package
		
		
		int borderTop = 215;
		app.imageMode(app.CENTER);

		if (selectedPackage == 1) {
			app.image(interPay, app.width / 2, borderTop, 665 / 2, 226 / 2);
		} else if (selectedPackage == 2) {
			app.image(moonPay, app.width / 2, borderTop, 665 / 2, 226 / 2);
		} else if (selectedPackage == 3) {
			app.image(marsPay, app.width / 2, borderTop, 665 / 2, 226 / 2);
		}
		
		app.imageMode(app.CORNER);

		app.fill(255);
		app.textFont(bold);
		app.textSize(20);
		app.text(logica.getPlanList().get(selectedPackage - 1).getName(), 30, 190);
		app.text("$" + logica.getPlanList().get(selectedPackage - 1).getPrice() + ".oo", 30, 255);
	
		app.textFont(light);
		app.fill(150);
		app.textSize(10);

		// Labels -- must disappear to write on textfields
		if (showNameInCard == true) {
			app.text("Cardholder's name", 22, 370);
			if (app.mousePressed == true && app.mouseX > 22 && app.mouseX < 300 && app.mouseY > 360
					&& app.mouseY < 390) {
				showNameInCard = false;
			}
		}
		if (showNumber == true) {
			app.text("Card number", 22, 430);
			if (app.mousePressed == true && app.mouseX > 22 && app.mouseX < 300 && app.mouseY > 420
					&& app.mouseY < 450) {
				showNumber = false;
			}
		}
		if (showDate == true) {
			app.text("Expiry date (MM/YY)", 22, 490);
			if (app.mousePressed == true && app.mouseX > 22 && app.mouseX < 300 && app.mouseY > 480
					&& app.mouseY < 510) {
				showDate = false;
			}
		}
		if (showSecurityCode == true) {
			app.text("Security code", 22, 550);
			if (app.mousePressed == true && app.mouseX > 22 && app.mouseX < 300 && app.mouseY > 540
					&& app.mouseY < 570) {
				showSecurityCode = false;
			}
		}

	}
	
	public void planSummary() {
		
		
	}

	public boolean fullInfo() {
		accepted = false;

		// Save fields to String variables
		name = cp5.get(Textfield.class, "Cardholder�s name").getText();
		number = cp5.get(Textfield.class, "Card number").getText();
		date = cp5.get(Textfield.class, "Expiry date (MM/YY)").getText();
		securityCode = cp5.get(Textfield.class, "Security code").getText();

		boolean nameEmpty = name.equals("");
		boolean numberEmpty = number.equals("");
		boolean dateEmpty = date.equals("");
		boolean securityCodeEmpty = securityCode.equals("");

		if (nameEmpty == false && numberEmpty == false && dateEmpty == false && securityCodeEmpty == false) {
			accepted = true;
		}

		return accepted;
	}

	public void clearAllFields() {
		cp5.get(Textfield.class, "Cardholder�s name").setText("");
		cp5.get(Textfield.class, "Card number").setText("");
		cp5.get(Textfield.class, "Expiry date (MM/YY)").setText("");
		cp5.get(Textfield.class, "Security code").setText("");

	}

	public void hide() {
		cp5.hide();
	}

	public ControlP5 getCp5() {
		return cp5;
	}

}
