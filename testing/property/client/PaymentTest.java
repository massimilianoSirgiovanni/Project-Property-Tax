package property.client;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PaymentTest {

	@Test
	void testPayment() {
		Payment p = new BankTransfer();
		Payment card = new CreditCardPayment();
		Client cl = new ConcreteClient(" Massimiliano ", Russia.generateState());
		cl.generatePaymentStrategy(p);
		assertEquals("Your payment by Bank Transfer has been made", cl.payTax());
		cl.generatePaymentStrategy(card);
		assertEquals("Your payment with Credit Card has been made", cl.payTax());
	}

}
