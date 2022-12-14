package course.c10.streamParallel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

class Employee {
	double salary;
	int id;
	String name;
	Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	void show() {
		System.out.println(id + ",  " + name + ", " + salary);
	}
	double getSalary() {
		return this.salary;
	}
}

public class Difference {

	private static List<Employee> getEmployees() {
		List<Employee> es = new ArrayList<>();
		es.add(new Employee(1, "Jim1", 1000));
		es.add(new Employee(2, "Jim2", 2000));
		es.add(new Employee(3, "Jim3", 3000));
		es.add(new Employee(3, "Jjjj", 4000));
		return es;
	}

	public static void imperativeProgramming() {
		double sum = 0;
		for (Employee e : getEmployees()) {
			if (e.name.startsWith("Jim") && e.salary >= 1500) {
				e.show();
				sum += e.salary;
			}
		}
		System.out.print(sum);
	}

	public static void streamingProgramming() {
		double sum = 
				getEmployees().stream()
				.filter(e -> e.name.startsWith("Jim"))
				.filter(e -> e.salary >= 1500)
				.peek(e -> e.show())
				.mapToDouble(e -> e.salary)
				.sum();
		System.out.print(sum);
	}

	public static void streamingProgramming2() {
		Stream<Employee> s1 = getEmployees().stream();
		Stream<Employee> s2 = s1.filter(e -> e.name.startsWith("Jim"));
		Stream<Employee> s3 = s2.filter(e -> e.salary >= 1500);
		Stream<Employee> s4 = s3.peek(e -> e.show());
		DoubleStream s5 = s4.mapToDouble(e -> e.salary);
		double sum = s5.sum();
		System.out.print(sum);
	}
	
	public static void parallelStreamingFromCollection() {
		double sum = 
				getEmployees().parallelStream()
				.filter(e -> e.name.startsWith("Jim"))
				.filter(e -> e.salary >= 1500)
				.peek(e -> e.show())
				.mapToDouble(e -> e.salary)
				.sum();
		System.out.print(sum);
	}
	
	public static void parallelStreamingFromStream() {
		double sum = 
				getEmployees().stream()
				.filter(e -> e.name.startsWith("Jim"))
				.filter(e -> e.salary >= 1500)
				.peek(e -> e.show())
				.mapToDouble(e -> e.salary)
				.parallel()
				.sum();
		System.out.print(sum);
	}
	
	public static void statefullStreaming() {
		List<Employee> eList = getEmployees();
		List<Employee> blockList = new ArrayList<>();
		eList.parallelStream()
		.filter(e -> e.name.startsWith("Jim"))
		.forEach(e -> blockList.add(e));
	}

	public static void statelessStreaming() {
		List<Employee> eList = getEmployees();
		List<Employee> nonblockList = 
				eList.parallelStream()
				.filter(e -> e.name.startsWith("Jim"))
				.collect(Collectors.toList());
	}
	
	public static void checkParallelResultOfSum() {
		List<Employee> eList = getEmployees();
		double r1 = eList.stream()
				.filter(e -> e.name.startsWith("Jim"))
				.mapToDouble(Employee::getSalary)
				.sequential()
				.sum();
		double r2 = eList.stream()
				.filter(e -> e.name.startsWith("Jim"))
				.mapToDouble(Employee::getSalary)
				.parallel()
				.sum();
		System.out.println(r1 == r2);
	}

	public static void checkParallelResultOfFindAny() {
		List<Employee> eList = getEmployees();
		Optional<Employee> e1 = eList.stream()
				.filter(e -> e.name.startsWith("Jim"))
				.sequential()
				.findAny();
		Optional<Employee> e2 = eList.stream()
				.filter(e -> e.name.startsWith("Jim"))
				.parallel()
				.findAny();
		System.out.println(e1.get().id == e2.get().id);
	}
	
	public static void main(String args[]) {
		imperativeProgramming();
		streamingProgramming();
	}

}
