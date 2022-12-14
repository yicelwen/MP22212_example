package course.c15.serial;

import java.io.*;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient int age;
	
	private String name;
	private String ssn;
	
	public Employee(int age, String name, String ssn) {
		super();
		this.age = age;
		this.name = name;
		this.ssn = ssn;
	}

	private static final ObjectStreamField[] serialPersistentFields = { 
			new ObjectStreamField("name", String.class),
			new ObjectStreamField("ssn", String.class) 
	};

	private static String encrypt(String input) {
		return input;
	}

	private static String decrypt(String input) {
		return input;
	}

	private void writeObject(ObjectOutputStream s) throws Exception {
		ObjectOutputStream.PutField fields = s.putFields();
		fields.put("name", name);
		fields.put("ssn", encrypt(ssn));
	//	fields.put("age", age);
		s.writeFields();
	}

	private void readObject(ObjectInputStream s) throws Exception {
		ObjectInputStream.GetField fields = s.readFields();
		this.name = (String) fields.get("name", null);
		this.ssn = decrypt((String) fields.get("ssn", null));
	}

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", ssn=" + ssn + "]";
	}
	
	
}
