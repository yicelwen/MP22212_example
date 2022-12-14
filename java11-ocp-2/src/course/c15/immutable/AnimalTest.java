package course.c15.immutable;

import java.util.ArrayList;

public class AnimalTest {

	public static void main(String[] args) throws Exception {
		ArrayList<String> food = new ArrayList<>();
		food.add("grass");
		AnimalV5 animal = new AnimalV5(food);
		AnimalV5 clone = (AnimalV5) animal.clone();
		System.out.println(animal == clone);
		System.out.println(animal.foods == clone.foods);
	}
}