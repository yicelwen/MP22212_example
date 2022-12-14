package course.c15.immutable.clone;

public class TestCloning {
	public static void main(String[] args) throws CloneNotSupportedException {
		testBaseRule();
		testShallowCopy();
	}
	public static void testBaseRule() throws CloneNotSupportedException {
		Department dept = new Department("IT");
		Employee original = new Employee(1, dept);
		Employee cloned = (Employee) original.clone();
		System.out.println(original != cloned);
		System.out.println(original.getClass() == cloned.getClass());
		System.out.println(original.equals(cloned));
	}
	public static void testShallowCopy() throws CloneNotSupportedException {
		Department dept = new Department("IT");
		Employee original = new Employee(1, dept);
		Employee cloned = (Employee) original.clone();
		// show department name
		System.out.println(original.getDept().getName());
		System.out.println(cloned.getDept().getName());
		// show department name
		cloned.getDept().setName("Finance");
		System.out.println(original.getDept().getName());
		System.out.println(cloned.getDept().getName());
	}
}
