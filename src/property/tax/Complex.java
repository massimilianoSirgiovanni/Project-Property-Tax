package property.tax;

import java.util.Iterator;
import java.util.LinkedList;

import property.workers.Workers;

public class Complex implements Estate {

	private String id;
	private LinkedList<Estate> propertyComplex = new LinkedList<Estate>();

	public Complex(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void add(Estate e) throws Exception {
		propertyComplex.add(e);

	}

	@Override
	public void remove(Estate e) throws Exception {
		propertyComplex.remove(e);
	}

	public Iterator<Estate> getIterator() {
		return propertyComplex.iterator();
	}

	@Override
	public double getTax(int coeff) {
		double sum = 0;
		Iterator<Estate> it = this.getIterator();
		while (it.hasNext()) {
			Estate current = it.next();
			sum = sum + current.getTax(coeff);
		}
		return sum;
	}

	@Override
	public void accept(VisitorEstate v) {
		v.visit(this);
	}

	@Override
	public boolean equals(Object ob) {
		boolean result = false;
		if (ob instanceof Complex) {
			if ((this.getId().equals(((Complex) ob).getId())) && confrontIterator(ob)) {
				result = true;
			}

		}
		return result;
	}

	public boolean confrontIterator(Object ob) {
		boolean x = true;
		Iterator<Estate> it = ((Complex) ob).getIterator();
		Iterator<Estate> it2 = this.getIterator();
		while (it.hasNext() && x) {
			if (!(it.next().equals(it2.next()))) {
				x = false;
			}

		}
		return x;
	}

	@Override
	public void addWorker(Workers w) throws Exception {
		throw new Exception("Unable to Add");

	}

	@Override
	public void removeWorker(Workers w) throws Exception {
		throw new Exception("Unable to remove");

	}

	public String document() {
		return " Complex: " + getId();
	}

}
