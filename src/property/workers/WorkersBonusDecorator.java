package property.workers;

public class WorkersBonusDecorator extends WorkersDecorator {

	private double bonus;
	private String reasonBonus;

	public WorkersBonusDecorator(Workers worker, double bonus, String reasonBonus) {
		super(worker);
		this.bonus = bonus;
		this.reasonBonus = reasonBonus;
	}

	public double getBonus() {
		return bonus;
	}

	public String getReasonBonus() {
		return reasonBonus;
	}

	public void setReasonBonus(String reasonBonus) {
		this.reasonBonus = reasonBonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public double getSalary() {
		double salary = super.getSalary();
		return salary + getBonus();
	}

	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Bonus: " + getBonus());
		System.out.println(" Task performed for the bonus : " + getReasonBonus());
	}
}
