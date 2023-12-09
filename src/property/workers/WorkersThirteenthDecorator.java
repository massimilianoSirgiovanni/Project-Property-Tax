package property.workers;

public class WorkersThirteenthDecorator extends WorkersDecorator {

	public WorkersThirteenthDecorator(Workers worker) {
		super(worker);
	}

	@Override
	public double getSalary() {
		return super.getSalary() * 2;
	}

	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println(" Increase Reason: Thirteenth");

	}
}
