package course.c15.serial;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Employee2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private int age;

	private String name;
	private String ssn;

	private Employee2() {
	}

	private static Map<String, Employee2> pool = new ConcurrentHashMap<>();

	public synchronized static Employee2 getEmployee2(String name) {
		if (pool.get(name) == null) {
			var e = new Employee2();
			e.name = name;
			pool.put(name, e);
		}
		return pool.get(name);
	}

	private static final ObjectStreamField[] serialPersistentFields = { 
			new ObjectStreamField("name", String.class),
			new ObjectStreamField("ssn", String.class) };

	public synchronized Object readResolve() throws ObjectStreamException {
		System.out.println("readResolve() was called~");
		var employee2InPool = pool.get(this.name);
		if (employee2InPool == null) {// new employee not in pool
			pool.put(this.name, this);
			return this;
		} else {
			// employee already in pool
			employee2InPool.name = this.name;
			employee2InPool.ssn = this.ssn;
			return employee2InPool;
		}
	}

	public Object writeReplace() throws ObjectStreamException {
		System.out.println("writeReplace() was called~");
		var e = pool.get(this.name);
		return e != null ? e : this;
	}

	private void writeObject(ObjectOutputStream s) throws Exception {
		System.out.println("writeObject() was called~");
		ObjectOutputStream.PutField fields = s.putFields();
		fields.put("name", name);
		fields.put("ssn", ssn);
		s.writeFields();
	}

	private void readObject(ObjectInputStream s) throws Exception {
		System.out.println("readObject() was called~");
		ObjectInputStream.GetField fields = s.readFields();
		this.name = (String) fields.get("name", null);
		this.ssn = (String) fields.get("ssn", null);
	}

	@Override
	public String toString() {
		return "Employee2 [age=" + age + ", name=" + name + ", ssn=" + ssn + "]";
	}

}
