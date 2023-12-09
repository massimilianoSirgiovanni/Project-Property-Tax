package property.client;

public class Italy implements State {

	private static State state;
	private TaxLaws law;

	private Italy() {

		this.law = new TaxLawItaly();

	}

	public static State generateState() {
		if (state == null) {
			state = new Italy();
		}
		return state;
	}

	@Override
	public TaxLaws getTaxLaw() {
		return law;
	}

}
