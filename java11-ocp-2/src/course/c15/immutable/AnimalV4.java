package course.c15.immutable;

import java.util.ArrayList;
import java.util.List;

public final class AnimalV4 {
	private final List<String> foods;

	public AnimalV4(List<String> foods) {
		if (foods == null)
			throw new RuntimeException("foods is required");
		this.foods = foods;
	//	this.foods = new ArrayList<String>(foods);
	}

	public int getFoodsCount() {
		return foods.size();
	}

	public String getFoodsElement(int index) {
		return foods.get(index);
	}

	public static void main(String args[]) {
		var favorites = new ArrayList<String>();
		favorites.add("Apples");
		var animal = new AnimalV4(favorites);
		System.out.println(animal.getFoodsCount());
		favorites.clear();
		System.out.println(animal.getFoodsCount());
	}

}