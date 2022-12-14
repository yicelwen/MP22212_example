package course.c03.ser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeOrder {

	public static void main(String[] args) {

		String output = System.getProperty("user.dir") + "\\src\\course\\c03\\ser\\file\\Order.ser";

		serialization(output);

	//	System.out.println("\n-----------------------------------------\n");
		
	//	deSerialization(output);
	}

	private static void serialization(String output) {
		// Create a shirts Order
		Shirt s1 = new Shirt("Brand1", 100, 100);
		Shirt s2 = new Shirt("Brand2", 100, 200);
		Shirt s3 = new Shirt("Brand3", 100, 300);
		Order o = new Order(s1, s2, s3);
		
		Order.staticField = 22;
		// Write out the Order
		try (FileOutputStream fos = new FileOutputStream(output);
				ObjectOutputStream out = new ObjectOutputStream(fos)) {
			out.writeObject(o);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("=== Before Serialization, " + o);
	}

	private static void deSerialization(String output) {
		// Read the Order back in
		try (FileInputStream fis = new FileInputStream(output); ObjectInputStream in = new ObjectInputStream(fis)) {
			Order restoredOrder = (Order) in.readObject();
			System.out.println("=== After Serialization, " + restoredOrder);
		} catch (ClassNotFoundException | IOException i) {
			i.printStackTrace();
		}
	}

}
