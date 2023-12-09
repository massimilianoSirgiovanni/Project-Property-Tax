package property.tax;

public class Luxury extends Home {

	private final double deduction;
	private double percentage;

	public Luxury(int id, double value, double deduction, double percentage) {
		super(id, value);
		this.deduction = deduction;
		this.percentage = percentage;
	}

	@Override
	public double getDeduction() {
		return deduction;
	}

	@Override
	public double getAliquota() {
		return (percentage * getValue());
	}

	@Override
	public void accept(VisitorEstate v) {
		v.visit(this);
	}

	public boolean instance(Object ob) {
		return ob instanceof Luxury;
	}

	public boolean equals(Object ob) {
		return ob instanceof Luxury && super.equals(ob);
	}

	@Override
	public String document() {
		return super.document() + " Luxury";
	}

}
