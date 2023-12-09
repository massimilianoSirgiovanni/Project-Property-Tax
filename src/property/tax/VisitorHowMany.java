package property.tax;

import java.util.Iterator;
import java.util.function.Predicate;

public class VisitorHowMany implements VisitorEstate {

	private int counter = 0;
	private Predicate<Estate> p;

	public VisitorHowMany(Predicate<Estate> p) {
		this.p = p;
	}

	public int getCounter() {
		return counter;
	}

	@Override
	public void visit(Economy e) {
		if (p.test(e)) {
			counter = counter + 1;

		}

	}

	@Override
	public void visit(Luxury l) {
		if (p.test(l)) {
			counter = counter + 1;

		}
	}

	public void visit(Military m) {
		if (p.test(m)) {
			counter = counter + 1;
		}
	}

	@Override
	public void visit(Religious r) {
		if (p.test(r)) {
			counter = counter + 1;

		}
	}

	@Override
	public void visit(Complex c) {
		Iterator<Estate> it = c.getIterator();
		it.forEachRemaining(e -> e.accept(this));
	}

	@Override
	public void visit(Shop s) {
		if (p.test(s)) {
			counter = counter + 1;

		}

	}

}
