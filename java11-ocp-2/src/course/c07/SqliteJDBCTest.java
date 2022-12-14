package course.c07;

import java.sql.*;
import java.util.Date;

public class SqliteJDBCTest {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:sqlite:c:/jim.db";
		// String username = "public";
		// String password = "tiger";
		String query = "SELECT * FROM Employee";
		Class.forName("org.sqlite.JDBC");
		try (Connection con = DriverManager.getConnection(url);
		// Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			DatabaseMetaData dbm = con.getMetaData();
			System.out.println("supportsANSI92EntryLevelSQL: " + dbm.supportsANSI92EntryLevelSQL());

			while (rs.next()) {
				int empID = rs.getInt("ID");
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				Date birthDate = rs.getDate("BirthDate");
				float salary = rs.getFloat("Salary");
				System.out.println("Employee ID: " + empID + "\n"
						+ "Employee Name: " + first + " " + last + "\n"
						+ "Birth Date: " + birthDate + "\n" + "Salary: "
						+ salary);
			}
		} catch (SQLException e) {
			System.out.println("SQL Exception: " + e);
		}
	}

}
