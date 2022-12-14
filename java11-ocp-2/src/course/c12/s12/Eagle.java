package course.c12.s12;

@ZooAnimal
public class Eagle extends Bird {

	@ZooSchedule(hours = { "4am", "5pm" })
	void clean() {
		System.out.print("Time to sweep up!");
	}

}
