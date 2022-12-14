package course.c09.asis;

public class Rock {
	private String name = this.getClass().getSimpleName();
	private double unitPrice;
	private double unitCost;
	private double weight;

	public Rock(double unitPrice, double unitCost, double weight) {
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.weight = weight;
	}
}
