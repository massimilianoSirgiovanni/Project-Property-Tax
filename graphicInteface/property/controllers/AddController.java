package property.controllers;

import property.tax.Estate;

public class AddController extends Controllers {

	@Override
	public void update(Estate e) throws Exception {

		getStr().getCl().addEstate(e);
	}

}
