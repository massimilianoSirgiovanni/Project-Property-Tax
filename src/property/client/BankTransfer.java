package property.client;

public class BankTransfer implements Payment {

	@Override
	public String pay() {

		return "Your payment by Bank Transfer has been made";
	}

}
