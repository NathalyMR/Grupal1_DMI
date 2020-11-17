package controller;

import model.Logica;

public class Controller {
	
	private static Controller controllerInstance;
	private Logica logica;
	
	private Controller() {
		
		logica.getInstance();
		
		
	}
	
	public static Controller getInstance() {

		if (controllerInstance == null) {
			controllerInstance = new Controller();
		}

		return controllerInstance;
	}
	
	public void startLogic() {
		

		
	}
	
public void getUserData(String name, String lastname, String email,String password, String nationality, int phoneNumber) {
		
		logica.registerNewUser(name, lastname,email,password,nationality,phoneNumber);
		
	}

}
