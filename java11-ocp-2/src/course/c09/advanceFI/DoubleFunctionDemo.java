package course.c09.advanceFI;

import java.util.function.DoubleFunction;

public class DoubleFunctionDemo {
	public static void main(String[] args) {
		DoubleFunction<String> calc = t -> String.valueOf(t * 10);
		/* use anonymous inner class:	
		DoubleFunction<String> calc = new DoubleFunction<String>() {
			public String apply(double v) {
				return String.valueOf(v * 3);
			}
		};	
		*/
		String result = calc.apply(3.1415926);
		System.out.println("New value is: " + result);
	}
}
