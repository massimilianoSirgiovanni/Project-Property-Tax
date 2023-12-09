package property.workers;

public abstract class Workers {

	public abstract String getName();

	public abstract double getSalary();

	public abstract void getInfo();

	public abstract int getId();

	public abstract double baseSalary();

	@Override
	public boolean equals(Object ob) {
		boolean x = false;
		if (ob instanceof Workers) {
			if (this.getName().equals(((Workers) ob).getName()) && this.baseSalary() == ((Workers) ob).baseSalary()
					&& this.getId() == ((Workers) ob).getId()) {
				x = true;
			}
		}
		return x;
	}
}