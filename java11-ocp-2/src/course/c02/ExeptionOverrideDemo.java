package course.c02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

abstract class Father {
	abstract void fatherMethod1() throws IOException;
	abstract void fatherMethod2() throws RuntimeException;
	abstract void fatherMethod3() throws SQLException;
}

class Child extends Father {
	@Override
	void fatherMethod1() throws IOException, FileNotFoundException {		
	}
	@Override
	void fatherMethod2() {
	}
	@Override
	void fatherMethod3() {		
	}
}
