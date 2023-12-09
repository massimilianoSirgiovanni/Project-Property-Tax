package property.workers;

public abstract class SingleWorker extends Workers {
	private double salary;
	private String name;
	private final int id;

	public SingleWorker(String name, double salary, int id) {
		this.salary = salary;
		this.name = name;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public double baseSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String getName() {

		return name;
	}

	@Override
	public double getSalary() {
		return salary;
	}

	public void getInfo() {
		System.out.println("Name: " + getName());
		System.out.println("ID: " + getId());
		System.out.println("Base Salary: " + getSalary());
	}

}
