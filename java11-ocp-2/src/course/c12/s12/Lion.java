package course.c12.s12;

@ZooAnimal
public class Lion extends Mammal {

	@ZooSchedule(hours = { "9am", "5pm", "10pm" })
	void feed() {
		System.out.print("Time to feed the lions!");
	}

}
