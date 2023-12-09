package property.tax;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComplexTest {

	@Test
	public void complexTest() throws Exception {
		Estate c = new Economy(19, 100001, 100000, 400, 200);
		Estate r = new Economy(13, 99999, 100000, 400, 200);
		Estate com = new Complex("Complesso Michelangelo");
		com.add(r);
		com.add(c);
		assertEquals(35998800, com.getTax(2), 0);
	}

	@Test
	public void ConfrontEqualityTestComplex() throws Exception {
		Estate c = new Luxury(7, 124.21, 12.5, 0.02);
		Estate f = new Economy(32, 100001, 100000, 400, 200);
		Estate b = new Complex(" Galileo ");
		Estate r = new Complex("Augusto");
		r.add(c);
		r.add(f);
		r.add(b);
		Estate d = new Complex("Bonaparte");
		d.add(c);
		d.add(f);
		d.add(b);
		assertEquals(false, d.equals(r));

	}

	@Test
	public void ConfrontEqualityTestComplex2() throws Exception {
		Estate c = new Luxury(7, 124.21, 12.5, 0.02);
		Estate f = new Economy(32, 100001, 100000, 400, 200);
		Estate b = new Complex(" Galileo ");
		Estate r = new Complex("Annibale");
		r.add(c);
		r.add(f);
		r.add(b);
		Estate d = new Complex("Annibale");
		d.add(c);
		d.add(f);
		d.add(b);
		assertEquals(true, d.equals(r));

	}
}
