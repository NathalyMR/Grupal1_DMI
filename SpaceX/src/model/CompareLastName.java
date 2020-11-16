package model;

import java.util.Comparator;

public class CompareLastName implements Comparator<Contact> {

	public CompareLastName() {
		
	}

	@Override
	public int compare(Contact o1, Contact o2) {
		
		return o1.getLastName().compareTo(o2.getLastName());
	}

}
