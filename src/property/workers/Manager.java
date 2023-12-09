package property.workers;

public class Manager extends SingleWorker {

	public Manager(String name, double salary, int id) {
		super(name, salary, id);
	}

	@Override
	public double getSalary() {

		double salary = super.getSalary();
		return salary * 2;
	}

	@Override
	public void getInfo() {
		System.out.println("Role: Manager");
		super.getInfo();
	}
}
