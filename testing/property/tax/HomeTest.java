package property.tax;

import static org.junit.Assert.*;

import org.junit.Test;

public class HomeTest {

	@Test
	public void Luxurytest() {
		Estate f = new Luxury(11, 100, 7, 0.02);
		assertEquals(193, f.getTax(1), 0);
	}

	@Test
	public void economyTest() {
		Estate c = new Economy(19, 100001, 100000, 400, 200);
		assertEquals(17999380, c.getTax(2), 0);
	}

	@Test
	public void ConfrontEqualityTest() {
		Estate g = new Economy(1, 2, 4, 5, 3);
		Estate f = new Economy(1, 5, 3, 5, 3);
		Estate p = new Luxury(1, 200, 3, 0.02);
		assertEquals(true, g.equals(f));
		assertEquals(false, g.equals(p));
	}
}
