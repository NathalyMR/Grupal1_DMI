package model;

import java.util.Comparator;

public class CompareAge implements Comparator <Contact> {

	public CompareAge() {

	}

	@Override
	public int compare(Contact o1, Contact o2) {
		
		return o1.getAge() - o2.getAge();
	}

}
