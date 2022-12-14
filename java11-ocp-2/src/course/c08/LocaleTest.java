package course.c08;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {
	public static void main(String[] args) {		
		Locale usLocale = Locale.US;				//MessagesBundle_en_US.properties
		Locale frLocale = Locale.FRANCE;			//MessagesBundle_fr_FR.properties
		Locale zhLocale = new Locale("zh", "CN");	//MessagesBundle_zh_CN.properties
		Locale twLocale = new Locale("zh", "TW");	//MessagesBundle_zh_TW.properties
		Locale ruLocale = new Locale("ru", "RU");	//MessagesBundle_ru_RU.properties
		Locale defaultLocale = Locale.getDefault();	//依目前所在地的locale，台灣為 MessagesBundle_zh_TW.properties
		Locale itLocale = Locale.ITALY;				//不存在
		Locale koLocale = Locale.KOREAN;			//不存在
		
		List<Locale> locales = new ArrayList<Locale>();
		locales.add(usLocale);
		locales.add(frLocale);
		locales.add(zhLocale);
		locales.add(twLocale);
		locales.add(ruLocale);
		locales.add(defaultLocale);
		locales.add(itLocale);
		locales.add(koLocale);
		
		for (Locale l: locales) {
			showLocaleValue(l, "menu1");
		}
	}
	private static void showLocaleValue(Locale locale, String key) {
		System.out.print(locale + ": ");
			ResourceBundle bundle = ResourceBundle.getBundle("MessagesBundle", locale);
		System.out.println(bundle.getLocale() + ": " + bundle.getString(key));
	}
}
