package course.c15.immutable;

import java.util.ArrayList;
import java.util.List;

public final class AnimalV1 {
	private final List<String> foods;

	public AnimalV1() {
		this.foods = new ArrayList<>();
		this.foods.add("Apples");
	}

	public List<String> getFoods() {
		return foods;
	}
	
	public static void main(String args[]) {
		AnimalV1 a = new AnimalV1();
		a.getFoods().clear();
		a.getFoods().add("poison");
	}
}
