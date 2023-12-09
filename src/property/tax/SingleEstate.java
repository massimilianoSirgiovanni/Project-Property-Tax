package property.tax;

public abstract class SingleEstate implements Estate {

	private final int id;
	private double value;

	public SingleEstate(int id, double value) {
		this.id = id;
		this.value = value;
	}

	public void add(Estate e) throws Exception {
		throw new Exception("Unable to Add");

	}

	public void remove(Estate e) throws Exception {
		throw new Exception("Unable to remove");
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public boolean equals(Object ob) {
		boolean result = false;
		if (this.getId() == ((SingleEstate) ob).getId()) {

			result = true;
		}
		return result;
	}

	public String document() {
		return "This Estate is:";
	}

}