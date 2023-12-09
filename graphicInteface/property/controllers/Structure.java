package property.controllers;

import property.client.*;

public class Structure {

	private ConcreteClient cl = new ConcreteClient(" ", Italy.generateState());
	private static Structure instance;

	private Structure() {
	}

	public static Structure generateStructure() {
		if (instance == null) {
			instance = new Structure();
		}
		return instance;

	}

	public ConcreteClient getCl() {
		return cl;
	}

}
