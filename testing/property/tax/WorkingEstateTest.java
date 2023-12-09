package property.tax;

import static org.junit.Assert.*;

import org.junit.Test;

import property.workers.Employer;
import property.workers.Workers;

public class WorkingEstateTest {

	@Test
	public void testMilitary() {
		Estate m = new Military(1, 100, 1);
		assertEquals(99, m.getTax(1), 0);
	}

	@Test
	public void testMilitary2() {
		Estate m = new Military(1, 1155, 15);
		assertEquals(2280, m.getTax(2), 0);
	}

	@Test
	public void testTotalSalary() {
		WorkingEstate m = new Military(1, 1155, 1);
		Workers c = new Employer("Pino", 100.0, 233);
		m.addWorker(c);
		assertEquals(100.0, m.getTotalSalary(), 0);
	}

	@Test
	public void testTotalSalary2() throws Exception {
		Estate m = new Military(1, 100, 10);
		Workers c = new Employer("Pino", 10, 789);
		Workers f = new Employer("Pino", 100, 34);
		m.addWorker(c);
		m.addWorker(f);
		assertEquals(290, m.getTax(2), 0);
	}

	@Test
	public void testShop() {
		Shop s = new Shop(1, 100, "Ristorante");
		assertEquals(50, s.getTax(1), 0);
	}

	@Test
	public void testReligious() {
		Estate r = new Religious(1, 100);
		assertEquals(50, r.getTax(1), 0);
	}

	@Test
	public void testEqualsMilitary() {
		Estate t = new Military(1, 100, 1);
		Estate c = new Military(1, 100, 1);
		assertEquals(true, t.equals(c));
	}

	@Test
	public void testEqualsShopMilitary() {
		Estate t = new Military(1, 100, 1);
		Estate s = new Shop(1, 100, "Pizza");
		assertEquals(false, t.equals(s));

	}
}
