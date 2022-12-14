package course.c12.s55;

import java.util.*;

public class UnSafeVarargsLab {
//	@SafeVarargs
	final Integer unsafeOperation(List<Integer>... manyIntegerList) {
		Object[] objArray = manyIntegerList;
		objArray[0] = Arrays.asList("error");
		return manyIntegerList[0].get(0); // ClassCastException at runtime
	}
	public static void main(String[] a) {
		var carrot = new ArrayList<Integer>();
		new UnSafeVarargsLab().unsafeOperation(carrot);
	}
}
