package course.c09.asis;

public class Widget {
	private String name = this.getClass().getSimpleName();
	private double unitPrice;
	private double unitCost;
	private double quantity;

	public Widget(double unitPrice, double unitCost, double quantity) {
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}
}
