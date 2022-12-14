package course.c05;

import java.util.*;

public class ConcurrentModificationExceptionTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		
		// fail-fast 1
		try {
			Iterator<Integer> iter = map.keySet().iterator();
			while (iter.hasNext()) {
				Integer key = iter.next();
				if (key >= 2) {
					map.remove(key);
				}
			}
		} catch (java.util.ConcurrentModificationException e) {
			e.printStackTrace();
		}
		
		// fail-fast 2
		try {
			for (Integer key : map.keySet()) {
				if (key >= 0) {
					map.remove(key);
				}
			}
		} catch (java.util.ConcurrentModificationException e) {
			e.printStackTrace();
		}
	}
}
