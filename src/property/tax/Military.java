package property.tax;

public class Military extends WorkingEstate {

	private double aliquota;

	public Military(int id, double value, double aliquota) {
		super(id, value);
		this.aliquota = aliquota;
	}

	public void accept(VisitorEstate v) {
		v.visit(this);

	}

	public double getAliquota() {
		return aliquota;
	}

	public boolean equals(Object ob) {
		return ob instanceof Military && super.equals(ob);
	}

	public String document() {
		return super.document() + " Military";
	}
}
