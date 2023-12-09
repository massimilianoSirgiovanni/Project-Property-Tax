package property.graphic;

import property.controllers.AddController;
import property.controllers.Controllers;
import property.tax.Estate;

public class AddHomeType extends ChooseHomeType {

	private Controllers addController = new AddController();

	@Override
	public void notifyControllers(Estate e) throws Exception {

		addController.update(e);

	}

	@Override
	public ChooseHomeType generateWindow() {
		return new AddHomeType();
	}

	public ChooseHomeOrWorkingEstate undo() {
		return new AddHomeOrWorkingEstate();

	}

}
