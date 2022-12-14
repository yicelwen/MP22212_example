package course.c09;

public class ContainsAnalyzer implements StringAnalyzer {
	public boolean analyze(String target, String keyStr) {
		return target.contains(keyStr);
	}
}
