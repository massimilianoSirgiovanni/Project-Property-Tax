package property.controllers;

import property.tax.Estate;

public class RemoveController extends Controllers {

	@Override
	public void update(Estate e) throws Exception {
		getStr().getCl().removeEstate(e);

	}

}
