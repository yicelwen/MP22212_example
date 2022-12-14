package course.c12.s26;

public @interface ConstantVarLab {

	int VAR1 = 1;

	public static final int VAR2 = 2;

	protected int VAR3 = 3; // 編譯失敗

	private int VAR4 = 4; // 編譯失敗

}
