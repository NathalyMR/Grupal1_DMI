package view;

import model.Logica;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * Main class 

 * @author: Juliana Cruz, Nicolas Montero

 * @version: 11/16/2020

 */

public class Main extends PApplet{
	
	PFont bold; //ROBOTO BOLD
	PFont light; //ROBOTO LIGHT
	
	static PImage register; //BACKGROUND IMAGE
	static PImage login; //BACKGROUND IMAGE
	static PImage home; //BACKGROUND IMAGE
	static PImage menu; //DROPDOWN MENU IMAGE
	static PImage contacts; //BACKGROUND IMAGE
	static PImage marsInfo; //BACKGROUND IMAGE
	static PImage moonInfo; //BACKGROUND IMAGE
	static PImage interInfo; //BACKGROUND IMAGE
	static PImage payment; //BACKGROUND IMAGE
	static PImage marsPay; //IMAGE FOR PAYMENT
	static PImage moonPay; //IMAGE FOR PAYMENT
	static PImage interPay; //IMAGE FOR PAYMENT
	static PImage congratsMars; //BACKGROUND IMAGE 
	static PImage congratsMoon; //BACKGROUND IMAGE 
	static PImage congratsInter; //BACKGROUND IMAGE 

	private HomeScreen homeScreen;
	private RegisterScreen registerScreen;
	private LogInScreen loginScreen;
	private ContactsScreen contactsScreen;
	private PackageScreen packageScreen;
	private PaymentScreen paymentScreen;
	
	private String screen = "home";
	private int selectedPackage = 0;

	
	// Menu
	private boolean showMenu=false;
	
	private Logica logica;


	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	
	
	public void settings() {
		size(360,750);
	}
	
	
	public void setup() {
		
		logica = Logica.getInstance();
		logica.initializeTravelPlanList();
		
		//LoadFonts----------------------------------
		bold = loadFont("Roboto-Bold-12.vlw");
		light = loadFont("Roboto-Light-12.vlw");
		
		//Load Images -------------------------------
		register = loadImage ("Register.png");
		login = loadImage ("Log In.png");
		home = loadImage ("Home.png");
		menu = loadImage ("DropdownMenu.png");
		contacts = loadImage ("Contacts.png");
		marsInfo = loadImage ("Mars.png");
		moonInfo = loadImage ("Moon.png");
		interInfo = loadImage ("Intercontinental.png");
		payment = loadImage ("Payment.png");
		moonPay = loadImage ("PayMoon.png");
		marsPay = loadImage ("PayMars.png");
		interPay = loadImage ("PayIntercontinental.png");
		congratsMars = loadImage ("CongratsMars.png");
		congratsMoon = loadImage ("CongratsMoon.png");
		congratsInter = loadImage ("CongratsInter.png");


		homeScreen = new HomeScreen(this);
		registerScreen = new RegisterScreen(this);
		loginScreen = new LogInScreen(this);
		contactsScreen = new ContactsScreen(this);
		packageScreen = new PackageScreen(this);
		paymentScreen = new PaymentScreen(this);
		
		registerScreen.paintTextfields(light);	
		
		loginScreen.paintTextfields(light);

		paymentScreen.paintTextfields(light);

	}
	
	public void draw() {

		switch(screen) { // Screens

				//0
		  case "register": // Register -- must fill 
			  
				registerScreen.paintScreen(register, bold);	
				registerScreen.fullInfo();	
				registerScreen.getCp5().show();
				loginScreen.getCp5().hide();
				paymentScreen.getCp5().hide();
				
				break;
				
				//1
		  case "logIn": // Log In -- must fill
			  
				loginScreen.paintScreen(login);
				loginScreen.fullInfo();
				loginScreen.getCp5().show();
				registerScreen.getCp5().hide();
				
				break;
				
				//2
		  case "home": // Travel Plans -- select one
				homeScreen.paintScreen(home);
				loginScreen.getCp5().hide();
				registerScreen.getCp5().hide();
				paymentScreen.getCp5().hide();
				
				break;
				
				//3
		  case "contacts": // Contacts -- add contact
				contactsScreen.paintScreen(contacts);

				break;
				
				//4
		  case "packages": // Packages (Intercontinental, Moon and Mars) -- add passenger or buy
			  	
			  textFont(bold);
			  if (selectedPackage == 1) {
			  	packageScreen.paintScreen(interInfo, selectedPackage);
			  	}else if (selectedPackage == 2) {
				  	packageScreen.paintScreen(moonInfo, selectedPackage);
				}else if (selectedPackage == 3) {
				  	packageScreen.paintScreen(marsInfo, selectedPackage);
				}
			  	
				break;
				
				//5
		  case "payment": //Payment -- fill
			  	paymentScreen.paintScreen(payment);
				paymentScreen.getCp5().show();
			  	paymentScreen.fullInfo();

				break;	
				
				//6
		  case "congrats": //Congratulations message
				paymentScreen.getCp5().hide();

				if (selectedPackage == 1) {
				  	image(congratsInter, 0, 0,360,750);
				}else if (selectedPackage == 2) {
				  	image(congratsMoon, 0, 0,360,750);
				}else if (selectedPackage == 3) {
					image(congratsMars, 0, 0,360,750);
				}
					
				break;	

		}
		
		dropdownMenu();
	}
	
	
	public void dropdownMenu() {
		
		int opacity = 30;
		
		if (showMenu == true) { // Drop-down Menu -- all screens except Log in and Register
			
			//Background opacity 30%
			fill(0,0,70,opacity);
			noStroke();
			rect(0,0,360,750);
			
			//Image
			image(menu, -53, -2,466,448);
			
		}
		
		System.out.println(showMenu);
		
	}

	
	public void mousePressed() { //Buttons
		
		/**
		 * Register screen interactions
		 */
		
		if (registerScreen.registered == true && screen == "register" && mouseX > 50 
				&& mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign Up button -- from Register to Home
			screen = "home";
			registerScreen.clearAllFields();
			return;
			}
		
		if (registerScreen.registered==false && screen == "register" && mouseX > 50 && mouseX < 320 
				&& mouseY > 563 && mouseY < 613) { //Sign In button -- not working if fields aren't full
			screen = "register";
			
			return;
			}
		
		if (screen == "register" && mouseX > 50 && mouseX < 640 && mouseY > 563 
				&& mouseY < 690) { //Sign In button -- from Register to Log in
			registerScreen.clearAllFields();
			screen = "logIn";
			return;
		}
		
		/**
		 * Login screen interactions
		 */
		
		if (loginScreen.logged == true && screen == "logIn" && mouseX > 50 
				&& mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign In button -- from Login to Home
			loginScreen.clearAllFields();
			registerScreen.clearAllFields();
			screen = "home";
			return;
		}
		
		if (loginScreen.logged == false && screen == "logIn" && mouseX > 50 
				&& mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign In button -- from Login to Home
			loginScreen.clearAllFields();
			screen = "logIn";
			return;
		}
		
		if (screen == "logIn" && mouseX > 50 && mouseX < 640 && mouseY > 563 
				&& mouseY < 690) { //Sign Up button -- from Login to Register
			loginScreen.clearAllFields();
			screen = "register";
			return;
			}
		
		/**
		 * Home interactions
		 */
		if (screen == "home") {
			selectedPackage = homeScreen.selectPlan();
			screen = "packages";
			return;
			}
		
		/**
		 * Packages screen interactions
		 */
		
		if (screen == "packages" && mouseX > 40 && mouseX < 320 && mouseY > 597 
				&& mouseY < 650) { //Add passenger button in Package-- from Package to Contacts

			screen = "contacts";
			return;
			}
		
		if (screen == "packages" && mouseX > 40 && mouseX < 320 && mouseY > 665 
				&& mouseY < 715) { //Buy button -- from Package to Payment
			
			screen = "payment";
			return;
			}
		
		/**
		 * Contacts screen interactions
		 */
		
		if (screen == "contacts" && mouseX > 40 && mouseX < 320 && mouseY > 665 
				&& mouseY < 715) { //Add passenger button in Contacts-- from Contacts to Package -- Must change price***

			screen = "packages";
			return;
			}
		
		/**
		 * Payment screen interactions
		 */
		
		if (screen == "payment" && mouseX > 40 && mouseX < 320 && mouseY > 665 
				&& mouseY < 715) { // Cancel Button in Payment - from Payment to Travel Plans
			
			screen = "home";
			return;
			}
		
		/**
		 * Payment results
		 */
		
		if (paymentScreen.accepted == true && screen == "payment" && mouseX > 40 
				&& mouseX < 320 && mouseY >  597 && mouseY < 650) { // Pay Button in Payment - from Payment to Congratulation message
			screen = "congrats";
			return;
			}
		
		if (paymentScreen.accepted == false && screen == "payment" && mouseX > 40 
				&& mouseX < 320 && mouseY >  597 && mouseY < 650) { // Pay Button in Payment - from Payment to Congratulation message
			screen = "payment";
			return;
			}
			
		/**
		 * Drop-down menu interactions
		 */
		
		if (showMenu == false && (screen != "register" || screen != "logIn")) {
			
			if (dist (mouseX, mouseY, 30, 60)< 50) { //Show menu -- all screens except Log in and Register 
				showMenu=true;
				return;
			}
		}
		
		if (showMenu == true) {
			
			if (mouseX > 23 && mouseX < 335 && mouseY > 116 
					&& mouseY < 140) { //Travel Plans option in drop-down menu
				screen = "home";
				selectedPackage = 0;
			}
			
			if (mouseX > 23 && mouseX < 335 && mouseY > 235 
					&& mouseY < 266) { //Mars option in drop-down menu
				selectedPackage = 3;
				screen = "packages";
			}
			
			if (mouseX > 23 && mouseX < 335 && mouseY > 192 
					&& mouseY < 229) { //Moon option in drop-down menu
				screen = "packages";
				selectedPackage = 2;
			}
			
			if (mouseX > 23 && mouseX < 335 && mouseY > 150 
					&& mouseY < 186) { //Intercontinental option in drop-down menu
				screen = "packages";
				selectedPackage = 1;
			}
			
			if (mouseX > 23 && mouseX < 335 && mouseY > 272 
					&& mouseY < 313) { //Contacts option in drop-down menu
				selectedPackage = 0;
				screen = "contacts";
			}
			
			if (dist (mouseX, mouseY, 30, 60)< 50 || (mouseX > 0 
					&& mouseX < 360 && mouseY > 387 && mouseY < 750) ) { // Hide menu 
				showMenu = false;
				return;
				
			}
			
			showMenu = false;
			return;	
		}
	}
}