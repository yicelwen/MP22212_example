package course.c02;

class Exception1 extends Exception {
}
class Exception2 extends Exception {
}
class Exception3 extends Exception {
}
public class ReThrowsExDemo {
	public void rethrowExBeforeJ7() throws Exception {
		try {
			if (Math.random()> 0.5) {
				throw new Exception1();
			} else {
				throw new Exception2();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	public void rethrowExAfterJ7() throws Exception1, Exception2 {
		try {
			if (Math.random()> 0.5) {
				throw new Exception1();
			} else {
				throw new Exception2();
			}
		} catch (Exception e) {
			throw e;
		}
	}
	public void rethrowNewExAfterJ7() throws Exception3 {
		try {
			if (Math.random()> 0.5) {
				throw new Exception1();
			} else {
				throw new Exception2();
			}
		} catch (Exception e) {
			throw new Exception3();
		}
	}
}
