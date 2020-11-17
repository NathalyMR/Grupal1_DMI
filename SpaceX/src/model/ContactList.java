package model;

import java.util.Collections;
import java.util.LinkedList;

public class ContactList {

	public LinkedList<Contact> contactos;

	private CompareLastName compareLastName;
	private CompareAge compareAge;
	private CompareNationality compareNat;
	private ComparePhoneNumber comparePhone;
	private CompareMail compareMail;

	public ContactList() {

		contactos = new LinkedList<Contact>();
		compareLastName = new CompareLastName();
		compareAge = new CompareAge();
		compareNat = new CompareNationality();
		compareMail = new CompareMail();

	}

	public void initializeContactList() {
		
		// Contacts test list
		
		contactos.add(new Contact ("Nicolas", "Montero", "nicolasmontero@gmail.com","Colombian", 20, 304123456, null));
		contactos.add(new Contact ("Juliana", "Cruz", "julianacruz@gmail.com","Colombian", 25, 356123456, null));
		contactos.add(new Contact ("Aaaaaa", "Zzzzzz", "aaaaazzzzz@gmail.com","Colombian", 35, 372839924, null));
	}

	public void drawList() {

	}

	public void sortList(String sortAttribute) {

		switch (sortAttribute) {

		case "name":
			Collections.sort(getContactsList());
			break;

		case "nationality":
			Collections.sort(getContactsList(), compareNat);
			break;
			
		case "mail":
			Collections.sort(getContactsList(), compareMail);
			break;
			
		case "lastName":
			Collections.sort(getContactsList(), compareLastName);
			break;
			
		case "phoneNumber":
			Collections.sort(getContactsList(), comparePhone);
			break;
			
		case "age":
			Collections.sort(getContactsList(), compareAge);
			break;

		}

	}

	public LinkedList<Contact> getContactsList() {
		return contactos;
	}

	public void setContactsList(LinkedList<Contact> contactos) {
		this.contactos = contactos;
	}

}
