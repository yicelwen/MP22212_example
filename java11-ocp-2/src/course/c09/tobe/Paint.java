package course.c09.tobe;

public class Paint implements ReportAble {
	private String name = this.getClass().getSimpleName();
	private double unitPrice;
	private double unitCost;
	private double volume;

	public Paint(double unitPrice, double unitCost, double volume) {
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.volume = volume;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getTotalPrice() {
		return this.volume * this.unitPrice;
	}

	@Override
	public double getTotalCost() {
		return this.volume * this.unitCost;
	}

	@Override
	public double getProfit() {
		return getTotalPrice() - getTotalCost();
	}
}
