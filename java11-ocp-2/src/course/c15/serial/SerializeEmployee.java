package course.c15.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeEmployee {

	public static void main(String[] args) {
		String output = System.getProperty("user.dir") + "/src/course/c15/serial/file/emp.ser";
		serialization(output);
		System.out.println("------------------------------------------------------------");
		deserialization(output);
	}

	private static void serialization(String output) {
		Employee emp = new Employee(100, "jim", "123456789");
		try (FileOutputStream fos = new FileOutputStream(output);
				ObjectOutputStream out = new ObjectOutputStream(fos)) {
			out.writeObject(emp);
		} catch (IOException i) {
			i.printStackTrace();
		}
		System.out.println("Before Serialization: " + emp);
	}

	private static void deserialization(String output) {
		try (FileInputStream fis = new FileInputStream(output); 
				ObjectInputStream in = new ObjectInputStream(fis)) {
			Employee empBack = (Employee) in.readObject();
			System.out.println("After Deserialization: " + empBack);
		} catch (ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
		}
	}

}
