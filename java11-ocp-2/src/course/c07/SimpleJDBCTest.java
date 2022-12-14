package course.c07;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class SimpleJDBCTest {
	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:derby://localhost:1527/myDB";
		String username = "root";
		String password = "sa";
		String query = "SELECT * FROM Employee";
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			while (rs.next()) {
				int empID = rs.getInt("ID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				Date birthDate = rs.getDate("BirthDate");
				float salary = rs.getFloat("Salary");
				System.out.println(empID + "\t" + first + "\t" + last + "\t" + birthDate + "\t" + salary);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e);
		}
	}
}