package course.c09.tobe;

public class ReportProduct {
	public ReportProduct() {
		System.out.println("** Sales Report **");
		System.out.println("Name\tPrice\tCost\tProfit\t");
		System.out.println("==============================");
	}
	public void show(ReportAble item) {
		System.out.println(item.getName() +
				"\t" + item.getTotalPrice() + 
				"\t" + item.getTotalCost() + 
				"\t" + item.getTotalPrice());
	}
	public static void main(String args[]) {
		ReportAble[] itemList = new ReportAble[5];
		ReportProduct report = new ReportProduct();
		itemList[0] = new Rock(15.0, 10.0, 50.0);
		itemList[1] = new Rock(11.0, 6.0, 10.0);
		itemList[2] = new Paint(13.0, 8.0, 25.0);
		itemList[3] = new Widget(7.0, 5.0, 10);
		itemList[4] = new Widget(12.0, 12.0, 20);
		for (ReportAble item : itemList) {
			report.show(item);
		}
	}
}
