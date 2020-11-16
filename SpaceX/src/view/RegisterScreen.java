package view;

import controlP5.ControlP5;
import controlP5.Textfield;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage; 

/**
 * Register Screen class 

 * @author: Juliana Cruz, Nicolás Montero

 * @version: 11/16/2020

 */

public class RegisterScreen { 
	private PApplet app;
	private boolean showName=true, showLastname=true, showEmail=true, showPassword=true, showNationality=true, showCellphone=true;
	private ControlP5 cp5;
	private String name, lastname, password, email, nationality, cellphone;
	private String[] registerInputs;
	public boolean registered=false;



	
	public RegisterScreen(PApplet app) {
		this.app = app;
		cp5 = new ControlP5(app);
		registerInputs = new String[6];
		

	}
	
	public void paintTextfields(PFont font) {

	registerInputs[0] = "Name";
	registerInputs[1] = "Last name";
	registerInputs[2] = "Email";
	registerInputs[3] = "Password";
	registerInputs[4] = "Nationality";
	registerInputs[5] = "Cellphone";
	
	
		for (int i = 0; i < registerInputs.length; i++) {

			cp5.addTextfield(registerInputs[i])
			.setPosition(30, 180 + (i * 60))
			.setSize(300, 30)
			.setAutoClear(true)
			.setColorValue(app.color(70))
			.setColorBackground(app.color(255, 255, 255, 1))
			.setFont(font)
			.setColorActive(app.color(255, 255, 255, 1))
			.setColorForeground(app.color(255, 255, 255, 1))
			.setColorCursor(100)
			.getCaptionLabel().hide();
			;
			}
		
		
	}
	
	public void paintScreen(PImage image,PFont font) {
		app.image(image, 0, 0,360,750);
		app.textFont(font);
		app.fill(150);
		
		// Labels -- must disappear to write on textfields
		if (showName==true) {
			app.text("Name", 30, 200);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 180 && app.mouseY < 215) {
				showName=false;
			}
		}
		if (showLastname==true) {
			app.text("Last name", 30, 260);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 240 && app.mouseY < 275) {
				showLastname=false;
			}
		}
		if (showEmail==true) {
			app.text("Email", 30, 320);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 300 && app.mouseY < 335) {
				showEmail=false;
			}
		}
		if (showPassword==true) {
			app.text("Password", 30, 380);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 360 && app.mouseY < 395) {
				showPassword=false;
			}
		}
		if (showNationality==true) {
			app.text("Nationality", 30, 440);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 420 && app.mouseY < 455) {
				showNationality=false;
			}
		}
		if (showCellphone==true) {
			app.text("Cellphone", 30, 500);
			if(app.mousePressed == true && app.mouseX > 30 && app.mouseX < 300 && app.mouseY > 480 && app.mouseY < 515) {
				showCellphone=false;
			}
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