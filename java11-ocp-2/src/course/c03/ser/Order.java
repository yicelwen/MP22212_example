package course.c03.ser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Shirt> shirts = new ArrayList<>();
	static int staticField = 100;
	transient int transientField = 100;

	public Order(Shirt... shirts) {
		for (Shirt s : shirts) {
			this.shirts.add(s);
		}
		staticField = 99;
		transientField = 99;
		System.out.println("--- Constructor is launched ---");
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		oos.defaultWriteObject();
		// keep the serialization date
		Date now = new Date();
		oos.writeObject(now);
		System.out.println("\nSerialized at: " + now + "\n");
	}
	
	// This method is called post-serialization
	private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
		ois.defaultReadObject();
		System.out.println("\nRestored from date: " + (Date) ois.readObject());
		System.out.println("Restored at: " + new Date() + "\n");
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("Order Summary ===\n");
		for (Shirt s : shirts) {
			sb.append(s);
		}
		sb.append("staticField = " + staticField);
		sb.append("\ntransientField = " + transientField);
		sb.append("\n------------------");
		return sb.toString();
	}
}
