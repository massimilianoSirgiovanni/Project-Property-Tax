package property.graphic;

public class AddHomeOrWorkingEstate extends ChooseHomeOrWorkingEstate {

	@Override
	public ChooseHomeType homeType() {

		return new AddHomeType();
	}

	@Override
	public ChooseHomeOrWorkingEstate generateHomeOrWorkingEstate() {

		return new AddHomeOrWorkingEstate();
	}

	@Override
	public ChooseWorkingEstateType workingType() {
		
		return new AddWorkingEstateType();
	}

}
