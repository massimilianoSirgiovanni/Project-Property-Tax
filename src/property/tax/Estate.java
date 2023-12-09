package property.tax;

import property.workers.Workers;

public interface Estate extends Visitable {

	public void add(Estate e) throws Exception;

	public void remove(Estate e) throws Exception;

	public double getTax(int coeff);

	public void addWorker(Workers w) throws Exception;

	public void removeWorker(Workers w) throws Exception;

	public String document();
}
