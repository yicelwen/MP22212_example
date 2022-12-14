package course.c12.s54;

import java.util.ArrayList;

import course.c12.s53.Planner;

@SuppressWarnings("removal")
public class PlannerUser {
	public static void main(String[] args) {
		Planner p = new Planner();
		@SuppressWarnings({ "rawtypes", "unchecked" })
		int qty = p.getTaskQty(new ArrayList());
		System.out.println(qty);
	}
}
