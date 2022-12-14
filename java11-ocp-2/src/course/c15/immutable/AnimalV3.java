package course.c15.immutable;

import java.util.ArrayList;
import java.util.List;

public final class AnimalV3 {
	private final List<String> foods;

	public AnimalV3() {
		this.foods = new ArrayList<>();
		this.foods.add("Apples");
	}

	public List<String> getFoods() {
		return List.copyOf(this.foods);
	}
}