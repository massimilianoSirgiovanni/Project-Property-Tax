package property.graphic;

import property.controllers.AddController;
import property.controllers.Controllers;
import property.tax.Estate;

public class AddWorkingEstateType extends ChooseWorkingEstateType {

	private Controllers addController = new AddController();

	@Override
	public void notifyControllers(Estate e) throws Exception {
		addController.update(e);
	}

	@Override
	public ChooseWorkingEstateType workingType() {
		return new AddWorkingEstateType();
	}

	public ChooseHomeOrWorkingEstate undo() {
		return new AddHomeOrWorkingEstate();

	}
}
