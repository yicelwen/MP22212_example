package course.c10.optional;

public class User {
	String name;

	Integer salary;

	public User() {
	}

	public User(String name) {
		this.name = name;
	}

	public User(String name, Integer salary) {
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public Integer getSalary() {
		return salary;
	}

}