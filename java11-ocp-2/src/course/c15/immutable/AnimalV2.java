package course.c15.immutable;

import java.util.ArrayList;
import java.util.List;

public final class AnimalV2 {
	private final List<String> foods;

	public AnimalV2() {
		this.foods = new ArrayList<>();
		this.foods.add("Apples");
	}

	public int getFoodsCount() {
		return foods.size();
	}

	public String getFoodsElement(int index) {
		return foods.get(index);
	}
}