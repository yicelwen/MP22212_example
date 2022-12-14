package course.c08;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatCurrency {

	public static void main(String[] args) {
		NumberFormat nf;

		nf = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Locale.US: " + nf.format(1000));

		nf = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
		System.out.println("Locale.TAIWAN: " + nf.format(1000.00));

		nf = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		System.out.println("Locale.JAPAN: " + nf.format(1000.00));
	}
}
