package property.client;

public class Russia implements State {

	private static State state;
	private TaxLaws law;

	private Russia() {
		this.law = new TaxLawRussia();
	}

	public static State generateState() {
		if (state == null) {
			state = new Russia();
		}
		return state;
	}

	@Override
	public TaxLaws getTaxLaw() {
		return law;
	}

}
