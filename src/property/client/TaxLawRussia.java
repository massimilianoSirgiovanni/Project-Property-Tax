package property.client;

public class TaxLawRussia implements TaxLaws {

	@Override
	public int getCoeff() {
		return 1;
	}

	@Override
	public double getMinDeduction() {
		return 40;
	}

	@Override
	public double getAliquota() {
		return 100;
	}

	@Override
	public double getPercentage() {
		return 0.03;
	}

	@Override
	public double getMaxDeduction() {
		return 20;
	}

	@Override
	public double getDeductionChangeValue() {
		return 20000;
	}

}
