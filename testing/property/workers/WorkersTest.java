package property.workers;

import static org.junit.Assert.*;

import org.junit.Test;

public class WorkersTest {

	@Test
	public void testWorkerDecorator() {
		Workers w = new Employer(" Walther ", 100, 711);
		Workers f = new WorkersBonusDecorator(w, 30, "");
		double result = f.getSalary();
		assertEquals(130, result, 0.01);

	}

	@Test
	public void testWorkerDecorator2() {
		Workers w = new Employer(" Light ", 100, 324);
		Workers f = new WorkersBonusDecorator(w, 30, "");
		Workers c = new WorkersThirteenthDecorator(f);
		assertEquals(260, c.getSalary(), 0);
	}

	@Test
	public void testWorkersEquals() {
		Workers w = new Employer(" Boadicea ", 100, 541);
		Workers v = new Employer(" Boadicea ", 100, 541);
		assertEquals(true, w.equals(v));
	}

	@Test
	public void testWorkersEquals2() {
		Workers w = new Employer(" Gianfilippo ", 100, 192);
		Workers f = new WorkersBonusDecorator(w, 30, "");
		Workers c = new WorkersThirteenthDecorator(f);
		assertEquals(true, w.equals(c));
	}

	@Test
	public void testWorkersManager() {
		Workers w = new Manager(" Armando ", 100, 455);
		Workers f = new WorkersBonusDecorator(w, 30, "");
		Workers c = new WorkersThirteenthDecorator(f);
		assertEquals(460, c.getSalary(), 0.01);
	}

	@Test
	public void testWorkersEquals3() {
		Workers w = new Employer(" Gianfilippo ", 100, 677);
		Workers v = new Employer(" Gianfilippo ", 260, 617);
		assertEquals(false, v.equals(w));
	}

	public void testWorkersEquals4() {
		Workers w = new Employer(" Gianfilippo ", 100, 192);
		Workers f = new WorkersBonusDecorator(w, 30, "");
		Workers c = new WorkersThirteenthDecorator(f);
		assertEquals(true, c.equals(w));
	}

}
