package model;

import java.util.Comparator;

public class CompareMail implements Comparator <Contact> {

	public CompareMail() {
		
	}

	@Override
	public int compare(Contact o1, Contact o2) {
		
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
