package course.c09.methodRefer;

@FunctionalInterface
public interface StudentFactory {

	Student createStudent(String name, int age);

}
