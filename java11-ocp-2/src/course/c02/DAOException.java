package course.c02;

import java.io.IOException;

public class DAOException extends Exception {
	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public static void main(String args[]) {
		try {
			throw new DAOException();
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		} 
		try {
			throw new DAOException("My Exception");
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		} 
		try {
			throw new DAOException(new Exception("hi"));
		} catch (DAOException e) {
			System.out.println(e.getMessage());
		} 
		try {
			throw new DAOException(new IOException("file oper error!!"));
		} catch (DAOException e) {
			System.out.println(e.getCause());
		} 
	}
}
