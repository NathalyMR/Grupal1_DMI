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

}
