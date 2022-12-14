package course.c12.s25;

public @interface ModiferLab {

	int element1();

	public abstract int element2();

	protected int element3(); // 編譯失敗

	private int element4(); // 編譯失敗

	final int element5(); // 編譯失敗

}
