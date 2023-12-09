package property.graphic;

public class RemoveHomeOrWorkingEstate extends ChooseHomeOrWorkingEstate {

	@Override
	public ChooseHomeType homeType() {

		return new RemoveHomeType();
	}

	@Override
	public ChooseHomeOrWorkingEstate generateHomeOrWorkingEstate() {

		return new RemoveHomeOrWorkingEstate();
	}

	@Override
	public ChooseWorkingEstateType workingType() {

		return new RemoveWorkingEstateType();
	}

}