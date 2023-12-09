package property.tax;

import java.util.Collection;
import java.util.LinkedList;

import property.workers.Workers;

public abstract class WorkingEstate extends SingleEstate implements Estate {
	private LinkedList<Workers> workers = new LinkedList<Workers>();

	public WorkingEstate(int id, double value) {
		super(id, value);
	}

	@Override
	public double getTax(int coeff) {
		return ((getValue() - getAliquota()) * coeff) + getTotalSalary();
	}

	public void addWorker(Workers w) {
		workers.add(w);
	}

	public void removeWorker(Workers w) {
		workers.remove(w);
	}

	public Collection<Workers> getCollection() {
		return workers;
	}

	public double getTotalSalary() {
		double sum = 0;
		Collection<Workers> salaryWorker = this.getCollection();
		sum = salaryWorker.stream().mapToDouble(w -> w.getSalary()).sum();
		return sum;
	}

	public abstract double getAliquota();

}
