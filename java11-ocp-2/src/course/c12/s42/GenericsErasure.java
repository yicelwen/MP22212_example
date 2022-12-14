package course.c12.s42;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericsErasure {
	public static void main(String args[]) {
		List<String> list = new ArrayList<String>();
		list.add("Hello");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
	}
}
