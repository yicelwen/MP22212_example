package course.c15.immutable;

import java.util.ArrayList;
import java.util.List;

public final class AnimalV5 implements Cloneable {
	private final List<String> foods;

	public AnimalV5(List<String> foods) {
		if (foods == null)
			throw new RuntimeException("foods is required");
		this.foods = foods;
	}

	public List<String> getFoods() {
		return foods;
	}

//	@Override
//	protected Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	
	@Override
	public AnimalV5 clone() throws CloneNotSupportedException {
		if (foods instanceof ArrayList) {
			List<String> cloned = (List) ((ArrayList) foods).clone();
			return new AnimalV5(cloned);
		} else {
			// 建立其他 List 實作型態的 clone()機制
			// 或是直接拋出例外終止複製
			throw new CloneNotSupportedException();
		}
	}

	public static void main(String[] args) throws Exception {
		List<String> food = new ArrayList<>();
		food.add("grass");
		AnimalV5 animal = new AnimalV5(food);
		AnimalV5 clone = (AnimalV5) animal.clone();
		System.out.println(animal == clone);
		System.out.println(animal.getFoods() == clone.getFoods());
	}
}