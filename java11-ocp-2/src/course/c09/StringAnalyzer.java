package course.c09;

@FunctionalInterface
public interface StringAnalyzer {
	public boolean analyze(String target, String keyStr);
}