package course.c12.s52;

@FunctionalInterface
interface MyInterface1 {
	int method1();
}

@FunctionalInterface
abstract class MyClass {	// 編譯失敗
	abstract String getName();
}

@FunctionalInterface
interface MyInterface2 {	// 編譯失敗
}

@FunctionalInterface
interface MyInterface3 {
	boolean method3();
}

@FunctionalInterface
interface MyInterface4 extends MyInterface3 {	// 編譯失敗
	void method4();
}

@FunctionalInterface
interface MyInterface5 extends MyInterface3 {
	boolean equals(Object unused);
}

public class FunctionalInterfaceLab {

}
