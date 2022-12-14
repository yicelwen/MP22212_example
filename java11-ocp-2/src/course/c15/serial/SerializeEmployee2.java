package course.c15.serial;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeEmployee2 {

	public static void main(String[] args) {
		String output = System.getProperty("user.dir") + "/src/course/c15/serial/file/emp2.ser";
		serialization(output);
		System.out.println("------------------------------------------------------------");
		deserialization(output);
	}

	private static void serialization(String output) {
		Employee2 emp = Employee2.getEmployee2("jim");
		try (FileOutputStream fos = new FileOutputStream(output);
				ObjectOutputStream out = new ObjectOutputStream(fos)) {
			out.writeObject(emp);
		} catch (IOException i) {
			i.printStackTrace();
		}
	}

	private static void deserialization(String output) {
		try (FileInputStream fis = new FileInputStream(output); 
				ObjectInputStream in = new ObjectInputStream(fis)) {
			Employee2 empBack = (Employee2) in.readObject();
		} catch (ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
		}
	}

}
