package model;

import java.util.Comparator;

public class CompareNationality implements Comparator <Contact> {

	public CompareNationality() {
	
	}

	@Override
	public int compare(Contact o1, Contact o2) {
		
		return o1.getNationality().compareTo(o2.getNationality());
	}

}
