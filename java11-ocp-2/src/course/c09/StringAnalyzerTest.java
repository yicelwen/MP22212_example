package course.c09;


public class StringAnalyzerTest {

	static void searchArr(String[] strArr, String keyStr, StringAnalyzer analyzer) {
		for (String str : strArr) {
			if (analyzer.analyze(str, keyStr)) {
				System.out.println(str);
			}
		}
	}

	static void test1() {
		String[] strArr = { "abc", "bcd", "efg" };
		searchArr(strArr, "b", new ContainsAnalyzer());
	}

	static void test2() {
		String[] strArr = { "abc", "bcd", "efg" };
		searchArr(strArr, "b", 
							new StringAnalyzer() {
								public boolean analyze(String target, String keyStr) {
									return target.contains(keyStr);
								}
							}
		);
	}

	static void test3() {
		String[] strArr = { "abc", "bcd", "efg" };
		searchArr(strArr, "b", (String t, String s) -> t.contains(s));
	}

	static void test4() {
		String[] strArr = { "abc", "bcd", "efg" };
		searchArr(strArr, "b", (t, s) -> t.contains(s));
		searchArr(strArr, "b", (t, s) -> t.startsWith(s));
		searchArr(strArr, "b", (t, s) -> t.endsWith(s));
	}

	static void test5() {
		String[] strArr = { "abc", "bcd", "efg" };

		StringAnalyzer sa1 = (t, s) -> t.contains(s);
		StringAnalyzer sa2 = (t, s) -> t.startsWith(s);
		StringAnalyzer sa3 = (t, s) -> t.endsWith(s);

		searchArr(strArr, "b", sa1);
		searchArr(strArr, "b", sa2);
		searchArr(strArr, "b", sa3);
	}

	public static void main(String[] args) {
		test1();
		test2();
	}

}
