package view;

import controlP5.ControlP5;
import controlP5.Textfield;
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

	public ControlP5 cp5;
	private String name, lastname, password, email, nationality, cellphone;
	private String[] registerInputs;

	
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

	HomeScreen homeScreen = new HomeScreen(this);
	RegisterScreen registerScreen = new RegisterScreen(this);
	LogInScreen loginScreen = new LogInScreen(this);
	ContactsScreen contactsScreen = new ContactsScreen(this);
	PackageScreen packageScreen = new PackageScreen(this);
	PaymentScreen paymentScreen = new PaymentScreen(this);
	
	private int screen = 0;
	private int selectedPackage = 0;

	
	// Menu
	private boolean showMenu=false;
	private boolean registered=false;
	
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

		cp5 = new ControlP5(this);

		
		// Register Inputs ------------------------------
		registerInputs = new String[6];
		registerInputs[0] = "Name";
		registerInputs[1] = "Last name";
		registerInputs[2] = "Email";
		registerInputs[3] = "Password";
		registerInputs[4] = "Nationality";
		registerInputs[5] = "Cellphone";
		
		
		for (int i = 0; i < registerInputs.length; i++) {

			cp5.addTextfield(registerInputs[i])
			.setPosition(30, 180 + (i * 60))
			.setSize(300, 30).setAutoClear(true)
			.setColorValue(color(70))
			.setColorBackground(color(255, 255, 255, 1))
			.setFont(light)
			.setColorActive(color(255, 255, 255, 1))
			.setColorForeground(color(255, 255, 255, 1))
			.setColorCursor(100)
			.getCaptionLabel().hide();
			;}
		


		
		
	}
	
	public void draw() {
		
		System.out.println(logica.getPlanList());
		
		fullInfo();
		textSize(12);
		//System.out.println(showMenu);
		
		//System.out.println(mouseX+"//"+mouseY); // Show coordinates
		
		//System.out.println(screen); //Show screen number
		System.out.println(registered);


		switch(screen) { // Screens

		  case 0: // Register -- must fill 
			  
				registerScreen.paintScreen(register, bold);	
				
				
						
				
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
			image(menu, -53, 0,466,437);
			
		}
	}
	
	

	
	public void mousePressed() { //Buttons
		
		if (registered==true && screen == 0 && mouseX > 50 && mouseX < 320 && mouseY > 563 && mouseY < 613) { //Sign Up button -- from Register to Home
			screen=2;
			clearAllFields();
			
			return;
		}
		
		if (registered==true && screen == 0 && mouseX > 50 && mouseX < 640 && mouseY > 563 && mouseY < 690) { //Sign In button -- from Register to Log in
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
		
		
	}
    
	
	public boolean fullInfo() {
		System.out.println("entra");
		registered=false;
		name=cp5.get(Textfield.class, "Name").getText();
		lastname=cp5.get(Textfield.class, "Last name").getText();
		email=cp5.get(Textfield.class, "Email").getText();
		password=cp5.get(Textfield.class, "Password").getText();
		nationality=cp5.get(Textfield.class, "Nationality").getText();
		cellphone=cp5.get(Textfield.class, "Cellphone").getText();
		
		boolean nameEmpty = name.equals("");
		boolean lastnameEmpty = lastname.equals("");
		boolean emailEmpty = email.equals("");
		boolean passwordEmpty = password.equals("");
		boolean nationalityEmpty = nationality.equals("");
		boolean cellphoneEmpty = cellphone.equals("");
		
		if(nameEmpty==false && lastnameEmpty==false && emailEmpty==false && passwordEmpty==false 
				&& nationalityEmpty==false && cellphoneEmpty ==false) {
			registered=true;
		}
		
		return registered;
	}
	
	public void clearAllFields() {
		cp5.get(Textfield.class, "Name").setText("");
		cp5.get(Textfield.class, "Last name").setText("");
		cp5.get(Textfield.class, "Email").setText("");
		cp5.get(Textfield.class, "Password").setText("");
		cp5.get(Textfield.class, "Nationality").setText("");
		cp5.get(Textfield.class, "Cellphone").setText("");

	}

	


}