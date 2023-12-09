package property.graphic;

import property.controllers.Controllers;
import property.controllers.RemoveController;
import property.tax.Estate;

public class RemoveHomeType extends ChooseHomeType {

	private Controllers removeController = new RemoveController();

	@Override
	public void notifyControllers(Estate e) throws Exception {

		removeController.update(e);

	}

	@Override
	public ChooseHomeType generateWindow() {
		return new RemoveHomeType();
	}

	public ChooseHomeOrWorkingEstate undo() {
		return new RemoveHomeOrWorkingEstate();

	}

}
