package property.client;

import property.tax.Complex;
import property.tax.Estate;

public class ConcreteClient extends Client {

	private Complex compl = new Complex("");

	public ConcreteClient(String name, State nationality) {
		super(name, nationality);
	}

	public double getTax() {

		return compl.getTax(getState().getTaxLaw().getCoeff());
	}

	public void addEstate(Estate e) throws Exception {
		compl.add(e);
	}

	public void removeEstate(Estate e) throws Exception {
		compl.remove(e);
	}

	public Complex getCompl() {
		return compl;
	}
}
