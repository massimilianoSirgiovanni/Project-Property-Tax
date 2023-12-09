package property.controllers;

public abstract class StringControllers {

	private final Structure str = Structure.generateStructure();

	public Structure getStr() {
		return str;
	}

	public abstract void update(String s);

}
