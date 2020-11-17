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
	
	public int screen = 0;
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

		
	}
	
	public void draw() {
		//System.out.println(mouseX+"//"+mouseY);
	


		switch(screen) { // Screens

		  case 0: // Register -- must fill 
			  
				registerScreen.paintScreen(register, bold);	
				registerScreen.fullInfo();		
				
				break;
				
		  case 1: // Log In -- must fill
			  
				loginScreen.paintScreen(login);
				loginScreen.fullInfo();
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
				
		  case 6: //Congratulations message
			  if (selectedPackage==1) {
				  	image(congratsInter, 0, 0,360,750);
				  	return;
				  	}else if (selectedPackage==2) {
				  		image(congratsMoon, 0, 0,360,750);
					  	return;
					}else if (selectedPackage==3) {
						image(congratsMars, 0, 0,360,750);
					  	return;
					}
					
					

				break;	

		}
		
		if (showMenu==true) { // Dropdown Menu -- all screens except Log in and Register
			
			//Background opacity 30%
			fill(0,0,70,30);
			noStroke();
			rect(0,0,360,750);
			
			//Image
			image(menu, -53, -2,466,445);
			
		}
	}
	
	

	
	public void mousePressed() { //Buttons
		//System.out.println(registerScreen.registered);
		if (screen == 4 && mouseX > 40 && mouseX < 320 && mouseY > 597 && mouseY < 650) { //Add passenger button in Package-- from Package to Contacts

			screen=3;
			showMenu=false;
			return;
			}
		
		if (screen == 4 && mouseX > 40 && mouseX < 320 && mouseY > 665 && mouseY < 715) { //Buy button -- from Package to Payment
			screen=5;
			showMenu=false;
			return;
			}
		
		if (screen == 3 && mouseX > 40 && mouseX < 320 && mouseY > 665 && mouseY < 715) { //Add passenger button in Contacts-- from Contacts to Package -- Must change price***

			screen=4;
			showMenu=false;
			return;
			}
		
		if (screen == 5 && mouseX > 40 && mouseX < 320 && mouseY > 665 && mouseY < 715) { // Cancel Button in Payment - from Payment to Travel Plans
			
			screen=2;
			showMenu=false;
			return;
			}
		
		if (screen == 5 && mouseX > 40 && mouseX < 320 && mouseY >  597 && mouseY < 650) { // Pay Button in Payment - from Payment to Congratulation message
			screen=6;
			showMenu=false;
			return;
			}
		
		if (registerScreen.registered==true && screen == 0 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign Up button -- from Register to Home
			screen=2;
			registerScreen.clearAllFields();
			
			return;
			}
		
		
			if (registerScreen.registered==false && screen == 0 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign In button -- not working if fields aren't full
				screen=0;
				
				return;}
				

		if (screen == 0 && mouseX > 50 && mouseX < 640 && mouseY > 563 && mouseY < 690) { //Sign In button -- from Register to Log in
			registerScreen.clearAllFields();
			screen=1;
			return;

		}
		
		
		if (loginScreen.logged==true && screen == 1 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign In button -- from Login to Home
			loginScreen.clearAllFields();
			screen=2;
			return;
		}
		
		if (loginScreen.logged==false && screen == 1 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign In button -- from Login to Home
			screen=1;
			return;
		}
		
		if (screen == 1 && mouseX > 50 && mouseX < 640 && mouseY > 563 && mouseY < 690) { //Sign Up button -- from Login to Register
			loginScreen.clearAllFields();
			screen=0;
			return;
			}
			
		if ((screen !=0 || screen!=1)  && mouseX > 22 && mouseX < 35 && mouseY > 52 && mouseY < 65 && showMenu== false) { //Show menu -- all screens except Log in and Register 
			showMenu=true;
			return;
		}
		
		if (showMenu==true && (mouseX > 22 && mouseX < 35 && mouseY > 52 && mouseY < 65) || (mouseX > 0 && mouseX < 360 && mouseY > 387 && mouseY < 750) ) { // Hide menu 
			showMenu=false;
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
    
	

}