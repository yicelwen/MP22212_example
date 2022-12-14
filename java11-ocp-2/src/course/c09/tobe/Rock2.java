package course.c09.tobe;

public class Rock2 extends ClassWithShow implements ReportAble {
	private String name = this.getClass().getSimpleName();
	private double unitPrice;
	private double unitCost;
	private double weight;

	public Rock2(double unitPrice, double unitCost, double weight) {
		this.unitPrice = unitPrice;
		this.unitCost = unitCost;
		this.weight = weight;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getTotalPrice() {
		return this.weight * this.unitPrice;
	}

	@Override
	public double getTotalCost() {
		return this.weight * this.unitCost;
	}

	@Override
	public double getProfit() {
		return getTotalPrice() - getTotalCost();
	}
	
}
