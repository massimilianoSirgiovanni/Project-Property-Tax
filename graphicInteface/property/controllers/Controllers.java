package property.controllers;

import property.tax.Estate;

public abstract class Controllers {

	private final Structure str = Structure.generateStructure();

	public Structure getStr() {
		return str;
	}

	public abstract void update(Estate e) throws Exception;

}
