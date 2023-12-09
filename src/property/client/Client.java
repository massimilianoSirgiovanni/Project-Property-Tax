package property.client;

public abstract class Client {

	private String name;
	private State nationality;
	private Payment paymentStrategy;

	public Client(String name, State nationality) {
		this.name = name;
		this.nationality = nationality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return nationality;
	}

	public String payTax() {
		return paymentStrategy.pay();
	}

	public abstract double getTax();

	public void generatePaymentStrategy(Payment paymentStrategy) {
		this.paymentStrategy = paymentStrategy;
	}
}
