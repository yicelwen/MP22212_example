package zoo.legacy;

import java.time.LocalDate;
import java.util.List;

import sun.misc.Unsafe;

//import jdk.internal.misc.Unsafe;

public class UnsafeBean {

	private List<String> list;
	private LocalDate date;

	public UnsafeBean(List<String> list, LocalDate visitDate) {
		this.list = list;
		this.date = visitDate;
	}

	public void unsafeMethod() {
		Unsafe unsafe = Unsafe.getUnsafe();
	}
}
