package property.client;

public class TaxLawItaly implements TaxLaws {

	@Override
	public int getCoeff() {

		return 2;
	}

	@Override
	public double getMinDeduction() {

		return 60;
	}

	@Override
	public double getAliquota() {
		return 40;
	}

	@Override
	public double getPercentage() {

		return 0.1;
	}

	@Override
	public double getMaxDeduction() {
		return 30;
	}

	@Override
	public double getDeductionChangeValue() {
		return 10000;
	}

}
