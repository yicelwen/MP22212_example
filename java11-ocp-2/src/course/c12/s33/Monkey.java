package course.c12.s33;

public class Monkey {
	@Music(types = { "Rock and roll" })
	String dance;
	@Music(types = "Classical")
	String sleep;
	@Music(types = {})
	String dislike1;
	@Music(types = "")
	String dislike2;
}
