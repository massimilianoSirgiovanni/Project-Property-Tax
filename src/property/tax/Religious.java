package property.tax;

public class Religious extends WorkingEstate {

	public Religious(int id, double value) {
		super(id, value);
	}

	@Override
	public void accept(VisitorEstate v) {
		v.visit(this);
	}

	@Override
	public double getAliquota() {
		return getValue() / 2;
	}

	public boolean equals(Object ob) {
		return ob instanceof Religious && super.equals(ob);
	}

	public String document() {
		return super.document() + " Religious";
	}

}
