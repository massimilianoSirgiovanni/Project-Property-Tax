package property.tax;

import property.workers.Workers;

public abstract class Home extends SingleEstate implements Estate {

	public Home(int id, double value) {
		super(id, value);
	}

	// Template
	public final double getTax(int coeff) {
		return ((getValue() * getAliquota()) - getDeduction()) * coeff;

	}

	@Override
	public void addWorker(Workers w) throws Exception {
		throw new Exception("Unable to Add");

	}

	@Override
	public void removeWorker(Workers w) throws Exception {
		throw new Exception("Unable to remove");

	}

	public abstract double getDeduction();

	public abstract double getAliquota();
}
