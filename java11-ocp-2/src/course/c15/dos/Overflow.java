package course.c15.dos;

public class Overflow {

	public static boolean enoughSpaceToAddLine(int requestedSize) {
		int maxLength = 1_000_000;
		String newLine = "END OF FILE";
		int newLineSize = newLine.length();
		return requestedSize + newLineSize < maxLength;
	}

	public static void main(String[] args) {
		System.out.println(enoughSpaceToAddLine(100));
		System.out.println(enoughSpaceToAddLine(2_000_000));
		System.out.println(enoughSpaceToAddLine(Integer.MAX_VALUE));
	}

}
