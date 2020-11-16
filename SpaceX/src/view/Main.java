package view;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Main extends PApplet{
	
	PFont bold; //ROBOTO BOLD
	PFont light; //ROBOTO LIGHT

	
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
	private int selectedPackage = 0;

	
	// Menu
	private int posXMenu, posYMenu; 
	private boolean showMenu=false;	
	


	public static void main(String[] args) {
		PApplet.main(Main.class.getName());
	}
	
	
	
	public void settings() {
		size(360,750);
	}
	
	
	
	
	public void setup() {
		//LoadFonts
		bold = loadFont("Roboto-Bold-64.vlw");
		light = loadFont("Roboto-Light-64.vlw");

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
		System.out.println(showMenu);
		
		//System.out.println(mouseX+"//"+mouseY); // Show coordinates

		switch(screen) { // Screens

		  case 0: // Register -- must fill 
			  
				registerScreen.paintScreen(register);
				
				break;
				
		  case 1: // Log In -- must fill
			  
				loginScreen.paintScreen(login);

				break;
				
		  case 2: // Travel Plans -- select one
				homeScreen.paintScreen(home);

				break;
				
				
		  case 3: // Conctacts -- add contact
				contactsScreen.paintScreen(contacts);

				break;
				
		  case 4: // Packages (Intercontinental, Moon and Mars) -- add passenger or buy
			  	if (selectedPackage==1) {
			  	packageScreen.paintScreen(interInfo);
			  	return;
			  	}else if (selectedPackage==2) {
				  	packageScreen.paintScreen(moonInfo);
				  	return;
				}else if (selectedPackage==3) {
				  	packageScreen.paintScreen(marsInfo);
				  	return;
				}
			  	
				break;
				
				
		  case 5: //Payment -- fill
			  	paymentScreen.paintScreen(payment);

				break;			

		}
		
		if (showMenu==true) { // Dropdown Menu -- all screens except Log in and Register
			
			//Background opacity
			fill(0,0,70,30);
			rect(0,0,360,750);
			
			//Image
			image(menu, -53, 0,466,418);
			
		}
	}
	
	
	/*Please work
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	public void mousePressed() {
		if (screen == 0 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign Up button -- from Register to Home
			screen=2;
			return;
		}
		
		if (screen == 0 && mouseX > 50 && mouseX < 640 && mouseY > 563 && mouseY < 690) { //Sign In button -- from Register to Log in
			screen=1;
			return;

		}
		if (screen == 1 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign In button -- from Login to Home
			screen=2;
			return;

		}
		
		if (screen == 1 && mouseX > 50 && mouseX < 640 && mouseY > 563 && mouseY < 690) { //Sign Up button -- from Login to Register
			screen=0;
			return;
			}
			
		if ((screen !=0 || screen!=1)  && mouseX > 22 && mouseX < 35 && mouseY > 52 && mouseY < 65) { //Show menu -- all screens except Log in and Register 
			showMenu=true;
			return;
		}
		if (showMenu==true && mouseX > 23 && mouseX < 335 && mouseY > 116 && mouseY < 140) { //Travel Plans option in dropdown menu
			screen = 2;
			showMenu=false;
			return;
		}
		
		if (showMenu==true && mouseX > 23 && mouseX < 335 && mouseY > 257 && mouseY < 285) { //Contacts option in dropdown menu
			screen = 3;
			showMenu=false;
			return;
		}
		
		if (showMenu==true && mouseX > 23 && mouseX < 335 && mouseY > 144 && mouseY < 177) { //Intercontinental option in dropdown menu
			selectedPackage=1;
			screen = 4;
			showMenu=false;
			return;
		}
		
		if (showMenu==true && mouseX > 23 && mouseX < 335 && mouseY > 182 && mouseY < 214) { //Moon option in dropdown menu
			screen = 4;
			selectedPackage=2;
			showMenu=false;
			return;
		}
		
		if (showMenu==true && mouseX > 23 && mouseX < 335 && mouseY > 218 && mouseY < 251) { //Mars option in dropdown menu
			screen = 4;
			selectedPackage=3;
			showMenu=false;
			return;
		}
	}
    
	public void keyPressed() {
		
	}
	}