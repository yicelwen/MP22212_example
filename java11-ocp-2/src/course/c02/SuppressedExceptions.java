package course.c02;

class TryException extends Exception {
}

class FinallyException extends Exception {
}

public class SuppressedExceptions {
	public static void main(String[] args) throws Exception {
		before7();
		after7();
	}

	private static void before7() {
		try {
			try {
				throw new TryException(); // This is lost
			} finally {
				throw new FinallyException();
			}
		} catch (Exception e) {
			System.out.println("before7: " + e.getClass());
		}
	}

	private static void after7() {
		try {
			Throwable t = null;
			try {
				throw new TryException();
			} catch (Exception e) {
				t = e;
			} finally {
				FinallyException fe = new FinallyException();
				if (t != null) {
					t.addSuppressed(fe);
					throw t;
				} else {
					throw fe;
				}
				
			}
		} catch (Throwable e) {
			System.out.println("after7: " + e.getClass());
			for (Throwable t : e.getSuppressed()) {
				System.out.println("after7: " + t.getClass());
			}
		}
	}

}
