package model;

import java.util.Comparator;

public class ComparePhoneNumber implements Comparator <Contact> {

	public ComparePhoneNumber() {

	}

	@Override
	public int compare(Contact o1, Contact o2) {
		
		return o1.getPhoneNumber() - o2.getPhoneNumber();
	}

}
