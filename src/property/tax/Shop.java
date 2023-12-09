package property.tax;

public class Shop extends WorkingEstate {

	private String name;

	public Shop(int id, double value, String name) {
		super(id, value);
		this.name = name;
	}

	@Override
	public void accept(VisitorEstate v) {
		v.visit(this);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getAliquota() {

		return (getValue() - getTotalSalary()) / 2;
	}

	public boolean equals(Object ob) {
		return ob instanceof Shop && super.equals(ob);
	}

	@Override

	public String document() {
		return super.document() + " Shop";
	}
}
