package property.graphic;

import property.controllers.Controllers;
import property.controllers.RemoveController;
import property.tax.Estate;

public class RemoveWorkingEstateType extends ChooseWorkingEstateType {

	private Controllers removeController = new RemoveController();

	@Override
	public void notifyControllers(Estate e) throws Exception {

		removeController.update(e);

	}

	@Override
	public ChooseWorkingEstateType workingType() {
		return new RemoveWorkingEstateType();
	}

	public ChooseHomeOrWorkingEstate undo() {
		return new RemoveHomeOrWorkingEstate();

	}
}