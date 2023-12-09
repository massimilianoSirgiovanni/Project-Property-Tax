package property.client;

public interface TaxLaws {

	public int getCoeff();

	public double getMinDeduction();

	public double getAliquota();

	public double getPercentage();

	public double getMaxDeduction();

	public double getDeductionChangeValue();
}
