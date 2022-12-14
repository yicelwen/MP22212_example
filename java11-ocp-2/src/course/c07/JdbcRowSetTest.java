package course.c07;

import java.sql.Date;
import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JdbcRowSetTest {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby://localhost:1527/myDB";
		String username = "root";
		String password = "sa";
		RowSetFactory myRowSetFactory = RowSetProvider.newFactory();
		try (JdbcRowSet jdbcRs = myRowSetFactory.createJdbcRowSet()) {
			jdbcRs.setUrl(url);
			jdbcRs.setUsername(username);
			jdbcRs.setPassword(password);
			jdbcRs.setCommand("SELECT * FROM Employee");
			jdbcRs.execute();
			while (jdbcRs.next()) {
				int empID = jdbcRs.getInt("ID");
				String first = jdbcRs.getString("FirstName");
				String last = jdbcRs.getString("LastName");
				Date birthDate = jdbcRs.getDate("BirthDate");
				float salary = jdbcRs.getFloat("Salary");
				System.out.println(
						"ID: " + empID + "\t" + 
						"Employee Name: " + first + " " + last + "\t" + 
						"Birth Date: " + birthDate + "\t" + 
						"Salary: " + salary);
			}
		}
	}
}
