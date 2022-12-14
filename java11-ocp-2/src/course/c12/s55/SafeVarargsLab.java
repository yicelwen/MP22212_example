package course.c12.s55;

public class SafeVarargsLab {

	@SafeVarargs
	public static void method1(int param) {
	} // 編譯失敗

	@SafeVarargs
	protected void method2(String... param) {
	} // 編譯失敗

	@SafeVarargs
	void method3(boolean... param) {
	} // 編譯失敗

}