package property.tax;

public class Economy extends Home {

	private double maxDeduction;
	private double minDeduction;
	private double deductionChangeValue;

	public Economy(int id, double value, double deductionChangeValue, double maxDeduction, double minDeduction) {
		super(id, value);
		this.deductionChangeValue = deductionChangeValue;
		this.maxDeduction = maxDeduction;
		this.minDeduction = minDeduction;
	}

	@Override
	public double getDeduction() {
		return (getValue() <= deductionChangeValue) ? minDeduction : maxDeduction;
	}

	@Override
	public double getAliquota() {
		return 90;
	}

	@Override
	public void accept(VisitorEstate v) {
		v.visit(this);
	}

	public boolean equals(Object ob) {
		return ob instanceof Economy && super.equals(ob);
	}

	public String document() {
		return super.document() + " Economy";
	}
}
