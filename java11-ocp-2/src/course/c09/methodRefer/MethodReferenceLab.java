package course.c09.methodRefer;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceLab {

	public static void main(String[] args) {
		String str = "E,D,a,C,b";
		String[] arr = str.split(",");
		
		System.out.println("\n--- noComparator()");
		noComparator(arr);
		
		System.out.println("\n--- byClassMethod()");
		byClassMethod(arr);
		
		System.out.println("\n--- byOutsideObjectMethod()");
		byOutsideObjectMethod(arr);
		
		System.out.println("\n--- byInsideObjectMethod()");
		byInsideObjectMethod(arr);
		
		System.out.println("\n--- byConstructorWithSupplier()");
		byConstructorWithSupplier();
				
		System.out.println("\n--- byConstructorWithFunction()");
		byConstructorWithFunction();
		
		System.out.println("\n--- byConstructorWithCustomFunction()");
		byConstructorWithCustomFunction();
	}

	static void printArray(String[] arr) {
		for (String s : arr) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
	
	// Arrays.sort()
	static void noComparator(String[] arr) {
		Arrays.sort(arr);
		printArray(arr);
	}

	// 「方法提供者」是「類別的靜態方法」，只是工具，不涉及物件狀態。
	static void byClassMethod(String[] arr) {
	//	Arrays.sort(arr, (a, b) -> StringUtil.compareIgnoreCase(a, b));
		Arrays.sort(arr, StringUtil::compareS);
		printArray(arr);
	}

	// 「方法提供者」是「物件參照變數」，且不是Lambda表示式的方法參數
	static void byOutsideObjectMethod(String[] arr) {
		StringUtil util = new StringUtil();
	//	Arrays.sort(arr, (a, b) -> util.compare(a, b));
		Arrays.sort(arr, util::compare);
		printArray(arr);
	}

	// 「方法提供者」是「物件參照變數」，且來自Lambda表示式的方法參數
	static void byInsideObjectMethod(String[] arr) {
	//	Arrays.sort(arr, (a, b) -> a.compareToIgnoreCase(b));
		Arrays.sort(arr, String::compareToIgnoreCase);
		printArray(arr);
	}
	
	
	// 參照建構子，只是靜態方法的變形
	static void byConstructorWithSupplier() {
	//	Supplier<Employee> supplier1 = () -> new Employee();
		Supplier<Employee> supplier2 = Employee::new;
		Employee emp = supplier2.get();
		emp.setName("Jim");
		System.out.println(emp.getName());
	}
	
	// 參照建構子，只是靜態方法的變形
	static void byConstructorWithFunction() {
	//	Function<String, Employee> factory1 = (s) -> new Employee(s);
		Function<String, Employee> factory2 = Employee::new;
		Employee emp = factory2.apply("Jim");
		System.out.println(emp.getName());
	}
	

	static void byConstructorWithCustomFunction() {
	//	StudentFactory factory = (name, age) -> new Student(name, age);
		StudentFactory factory = Student::new;
		Student s = factory.createStudent("Jim", 10);
		System.out.println(s);
	}
	
	

}



