package view;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{
	
	static PImage register; //BACKGROUND
	static PImage login; //BACKGROUND
	static PImage home; //BACKGROUND
	static PImage menu; //DROPDOWN MENU
	static PImage contacts; //BACKGROUND
	static PImage marsImage; //IMAGE FOR HOME
	static PImage interImage; //IMAGE FOR HOME
	static PImage moonImage; //IMAGE FOR HOME
	static PImage marsInfo; //BACKGROUND
	static PImage moonInfo; //BACKGROUND
	static PImage interInfo; //BACKGROUND
	static PImage payment; //BACKGROUND
	static PImage marsPay; //IMAGE FOR PAYMENT
	static PImage moonPay; //IMAGE FOR PAYMENT
	static PImage interPay; //IMAGE FOR PAYMENT


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
		}
	}