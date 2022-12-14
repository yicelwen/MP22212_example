package course.c09.tobe;

public class Widget implements ReportAble {
	private String name = this.getClass().getSimpleName();
	private double unitPrice;
	private double unitCost;
	private double quantity;

	public Widget(double unitPrice, double unitCost, double quantity) {
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.quantity = quantity;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getTotalPrice() {
		return this.quantity * this.unitPrice;
	}

	@Override
	public double getTotalCost() {
		return this.quantity * this.unitCost;
	}

	@Override
	public double getProfit() {
		return getTotalPrice() - getTotalCost();
	}
}
