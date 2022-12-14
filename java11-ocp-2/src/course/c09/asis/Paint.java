package course.c09.asis;

public class Paint {
	private String name = this.getClass().getSimpleName();
	private double unitPrice;
	private double unitCost;
	private double volume;

	public Paint(double unitPrice, double unitCost, double volume) {
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.volume = volume;
	}
}
