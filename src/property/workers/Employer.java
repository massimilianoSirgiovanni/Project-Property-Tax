package property.workers;

public class Employer extends SingleWorker {

	public Employer(String name, double salary, int id) {
		super(name, salary, id);
	}

	@Override
	public void getInfo() {
		System.out.println("Role: Employer");
		super.getInfo();
	}

}
