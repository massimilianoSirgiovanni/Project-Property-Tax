package property.client;

public class CreditCardPayment implements Payment {

	@Override
	public String pay() {
		
		return "Your payment with Credit Card has been made";
	}

}
