package course.c07;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleJDBCTest2 {

	public static void main(String[] args) throws ClassNotFoundException {
		String url = "jdbc:derby://localhost:1527/myDB";
		String username = "root";
		String password = "sa";
		String money = "50000";
		String query = "SELECT * FROM Employee WHERE Salary > " + money;
		Class.forName("org.apache.derby.client.ClientAutoloadedDriver");
		try (Connection con = DriverManager.getConnection(url, username, password);
				Statement stmt = con.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query)) {
			showDatabaseMetaData(con);
			System.out.println("------------------------------------");
			showResultSetMetaData(rs);
			System.out.println("------------------------------------");
			System.out.println("Row Count: " + rowCountByCursor(rs));
			System.out.println("------------------------------------");
			System.out.println("Row Count: " + rowCountBySQL(con, money));
			System.out.println("------------------------------------");
			printResultSet(rs);
			System.out.println("------------------------------------ runCallableStatement()");
			runCallableStatement(con);
			System.out.println("------------------------------------ runCallableStatement()");
			runCallableStatement(con, Float.valueOf(money));
			System.out.println("------------------------------------ runPreparedStatement()");
			runPreparedStatement(con, Double.valueOf(money));
			System.out.println("------------------------------------ runSqlInjection()");
			runSqlInjection(con, money + " or 1=1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int rowCountByCursor(ResultSet rs) throws SQLException {
		int rowCount = 0;
		int currRow = rs.getRow();
		if (!rs.last())	//使用last()方法將游標移到最後一筆資料。若發現沒資料，回傳false
			return -1;
		rowCount = rs.getRow();
		// Return the cursor to the current position
		if (currRow == 0)
			rs.beforeFirst();
		else
			rs.absolute(currRow);
		return rowCount;
	}

	
	private static int rowCountBySQL(Connection con, String money) throws SQLException {
		String query = "SELECT COUNT(*) FROM Employee WHERE Salary > " + money;
		try (Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {
			rs.next();
			int count = rs.getInt(1);
			return count;
		}
	}


	private static void showDatabaseMetaData(Connection con) throws SQLException {
		DatabaseMetaData dbm = con.getMetaData();
		System.out.println("Support for Entry-level SQL-92 standard: " + dbm.supportsANSI92EntryLevelSQL());
	}

	private static void showResultSetMetaData(ResultSet rs) throws SQLException {
		int numCols = rs.getMetaData().getColumnCount();
		String[] colNames = new String[numCols];
		String[] colTypes = new String[numCols];
		for (int i = 0; i < numCols; i++) {
			colNames[i] = rs.getMetaData().getColumnName(i + 1);
			colTypes[i] = rs.getMetaData().getColumnTypeName(i + 1);
		}
		System.out.println("Number of columns returned: " + numCols);
		System.out.println("Column names/types returned: ");
		for (int i = 0; i < numCols; i++) {
			System.out.println(colNames[i] + " : " + colTypes[i]);
		}
	}

	private static void printResultSet(ResultSet rs) throws SQLException {
		while (rs.next()) {
			int empID = rs.getInt("ID");
			String first = rs.getString("FirstName");
			String last = rs.getString("LastName");
			Date birthDate = rs.getDate("BirthDate");
			float salary = rs.getFloat("Salary");
			System.out.println("Employee ID: " + empID + "\t"
					+ "Employee Name: " + first + " " + last + "\t"
					+ "Birth Date: " + birthDate + "\t" + "Salary: " + salary);
		} 
	}
	
	private static void runPreparedStatement(Connection con, double value) throws SQLException {
		String query = "SELECT * FROM Employee WHERE Salary > ? ";
		PreparedStatement pStmt = con.prepareStatement(query);
		pStmt.setDouble(1, value);
		ResultSet rs = pStmt.executeQuery();
		printResultSet(rs);
	}	
	
	private static void runSqlInjection(Connection con, String value) throws SQLException {
		String query = "SELECT * FROM Employee WHERE Salary > " + value;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		printResultSet(rs);
	}
	
	private static void runCallableStatement(Connection con) throws SQLException, ParseException {
		CallableStatement cStmt = con.prepareCall("{CALL EMP_AGE_COUNT (?, ?)}");
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date parsed = format.parse("1957/06/11");
		java.sql.Date date = new java.sql.Date(parsed.getTime());
		cStmt.setDate(1, date);
		cStmt.registerOutParameter(2, Types.INTEGER); // 設定第2個參數是結果
		boolean result = cStmt.execute();
		int count = cStmt.getInt(2); // 取得第2個參數的值，即為結果
		System.out.println("Result : " + result);
		System.out.println("There are " + count + " Employees that birthday <= " + date);
	}
	
	private static void runCallableStatement(Connection con, float salary) throws SQLException {
		CallableStatement cStmt = con.prepareCall("{CALL EMP_SALARY_COUNT (?, ?)}");
		cStmt.setFloat(1, salary);
		cStmt.registerOutParameter(2, Types.INTEGER);	//設定第2個參數是結果
		boolean result = cStmt.execute();
		int count = cStmt.getInt(2);	//取得第2個參數的值，即為結果
		System.out.println("Result : " + result);
		System.out.println("There are " + count + " Employees over the salary of " + salary);
	}

}