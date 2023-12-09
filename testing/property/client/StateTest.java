package property.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StateTest {

	@Test
	void testState() {
		State italy = Italy.generateState();
		State russia = Russia.generateState();
		boolean x = italy.getTaxLaw().getCoeff() == russia.getTaxLaw().getCoeff();
		assertEquals(x, false);
	}

}
