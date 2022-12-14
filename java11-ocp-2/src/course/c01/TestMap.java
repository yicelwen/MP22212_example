package course.c01;

import java.util.*;

public class TestMap {

	public static void main(String[] args) {
		Map<String, String> partList = new TreeMap<>();
		partList.put("A02", "Edwin");
		partList.put("A01", "Jason");
		partList.put("A03", "Sonic");

		partList.put("A03", "Howard"); // Overwrite value

		// print all values
		Collection<String> values = partList.values();
		for (String v : values) {
			System.out.println(v);
		}

		// print all keys & values
		Set<String> keys = partList.keySet();
		for (String key : keys) {
			System.out.println("#" + key + ": " + partList.get(key));
		}
	}

}
