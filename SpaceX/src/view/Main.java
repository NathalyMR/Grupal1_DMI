package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	static PImage register; //BACKGROUND IMAGE
	static PImage login; //BACKGROUND IMAGE
	static PImage home; //BACKGROUND IMAGE
	static PImage menu; //DROPDOWN MENU IMAGE
	static PImage contacts; //BACKGROUND IMAGE
	static PImage marsImage; //IMAGE FOR HOME
	static PImage interImage; //IMAGE FOR HOME
	static PImage moonImage; //IMAGE FOR HOME
	static PImage marsInfo; //BACKGROUND IMAGE
	static PImage moonInfo; //BACKGROUND IMAGE
	static PImage interInfo; //BACKGROUND IMAGE
	static PImage payment; //BACKGROUND IMAGE
	static PImage marsPay; //IMAGE FOR PAYMENT
	static PImage moonPay; //IMAGE FOR PAYMENT
	static PImage interPay; //IMAGE FOR PAYMENT

	HomeScreen homeScreen = new HomeScreen(this);
	RegisterScreen registerScreen = new RegisterScreen(this);
	LogInScreen loginScreen = new LogInScreen(this);
	ContactsScreen contactsScreen = new ContactsScreen(this);
	PackageScreen packageScreen = new PackageScreen(this);
	PaymentScreen paymentScreen = new PaymentScreen(this);

	private int screen = 0;

	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	public void settings() {
		size(360,750);
	}
	
	public void setup() {
		
		//Load Images 
		register = loadImage ("Register.png");
		login = loadImage ("Log In.png");
		home = loadImage ("Home.png");
		menu = loadImage ("DropdownMenu.png");
		contacts = loadImage ("Contacts.png");
		marsImage = loadImage ("PackageMars.png");
		moonImage = loadImage ("PackageMoon.png");
		interImage = loadImage ("PackageIntercontinental.png");
		marsInfo = loadImage ("Mars.png");
		moonInfo = loadImage ("Moon.png");
		interInfo = loadImage ("Intercontinental.png");
		payment = loadImage ("Payment.png");
		moonPay = loadImage ("PayMoon.png");
		marsPay = loadImage ("PayMars.png");
		interPay = loadImage ("PayIntercontinental.png");

	}
	
	public void draw() {
		
	
		switch(screen) { // Screens

		  case 0: 
				registerScreen.paintScreen(register);

				break;
				
		  case 1: 
				loginScreen.paintScreen(login);

				break;
				
		  case 2: 
				homeScreen.paintScreen(home);

				break;
		  case 3: 
				contactsScreen.paintScreen(contacts);

				break;
				
		  case 4: 
			  	packageScreen.paintScreen(marsInfo);

				break;
		  case 5: 
			  	paymentScreen.paintScreen(payment);

				break;
						
				

		}}
	
	public void mousePressed() {
		
	}
    
	public void keyPressed() {
		
	}
	}