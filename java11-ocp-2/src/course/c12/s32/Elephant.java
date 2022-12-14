package course.c12.s32;

public class Elephant {
	@Hurt("Legs")
	public void fallDown() {
	}

	@Hurt(value = "Legs")
	public void fallOver() {
	}

	@Hurt
	String injuries[];
}
