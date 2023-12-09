package property.tax;

import static org.junit.Assert.*;

import org.junit.Test;

public class VisitorHowManyTest {
	@Test
	public void testVisitorHowManywithMilitary() {
		Estate m = new Military(1, 1155, 1);
		VisitorHowMany v = new VisitorHowMany(e -> e.getTax(2) > 100000000);
		m.accept(v);
		assertEquals(0, v.getCounter());
	}

	@Test
	public void testVisitorHowManywithComplex() throws Exception {
		Estate c = new Complex("Lorenzo il Magnifico");
		Estate t = new Military(1, 100, 1);
		Estate r = new Religious(1, 100);
		Estate l = new Military(1, 1000, 1);
		Estate s = new Shop(1, 100, "Pizza da Zio Luigi");
		c.add(r);
		c.add(t);
		c.add(l);
		c.add(s);
		VisitorHowMany v = new VisitorHowMany(e -> e.getTax(1) < 100);
		c.accept(v);
		assertEquals(3, v.getCounter());
	}

}
