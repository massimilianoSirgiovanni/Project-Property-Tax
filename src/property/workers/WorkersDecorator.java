package property.workers;

public abstract class WorkersDecorator extends Workers {

	private Workers worker;

	public WorkersDecorator(Workers worker) {
		this.worker = worker;
	}

	@Override
	public String getName() {
		return worker.getName();
	}

	@Override
	public double getSalary() {

		return worker.getSalary();
	}

	@Override
	public void getInfo() {

		worker.getInfo();
		System.out.println("Current Salary: " + getSalary());
	}

	public double baseSalary() {
		return worker.baseSalary();
	}

	@Override
	public int getId() {
		return worker.getId();
	}

}
