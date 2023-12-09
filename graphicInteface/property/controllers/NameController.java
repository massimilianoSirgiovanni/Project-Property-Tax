package property.controllers;

public class NameController extends StringControllers {

	@Override
	public void update(String s) {
		getStr().getCl().setName(s);
	}

}
