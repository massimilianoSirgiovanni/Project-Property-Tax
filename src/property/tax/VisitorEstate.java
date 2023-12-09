package property.tax;

public interface VisitorEstate {

	void visit(Economy e);

	void visit(Luxury l);

	void visit(Complex c);

	void visit(Military m);

	void visit(Religious r);

	void visit(Shop s);
}
