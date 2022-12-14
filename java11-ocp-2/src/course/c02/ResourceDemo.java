package course.c02;

class ResourceOpenException extends Exception {
}

class ResourceWorkingException extends Exception {
}

class ResourceCloseException extends Exception {
}

class Resource implements AutoCloseable {

	public Resource() throws Exception {
		System.out.println("The resource is created.");
		// throw new ResourceOpenException();
	}

	public void work() throws Exception {
		System.out.println("The resource is working.");
		throw new ResourceWorkingException();
	}

	@Override
	public void close() throws Exception {
		System.out.println("The resource is closed.");
		// throw new ResourceCloseException();
	}
}

public class ResourceDemo {
	public static void main(String[] args) throws Exception {
		try (Resource r = new Resource()) {
			r.work();
		} catch (Exception e) {
			System.out.println("Catch a exception: " + e.getClass());
		} finally {
			System.out.println("Final block ... ");
		}
	}
}
