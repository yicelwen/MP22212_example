package course.c15.injection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlLab {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:derby://localhost:1527/1Z0819";
		String username = "sa";
		String password = "root";
		Connection conn = DriverManager.getConnection(url, username, password);

		// normal as Statement
		String normalInput = "monday";
		int opening = getOpening1(conn, normalInput);
		System.out.println(opening);

		// malicious as Statement
		String maliciousInput = "monday' OR day IS NOT NULL OR day = 'sunday";
		opening = getOpening1(conn, maliciousInput);
		System.out.println(opening);

		// malicious as incorrect prepareStatement
		opening = getOpening2(conn, maliciousInput);
		System.out.println(opening);

		// malicious as correct prepareStatement
		opening = getOpening3(conn, maliciousInput);
		System.out.println(opening);

	}

	public static int getOpening1(Connection conn, String day) throws SQLException {
		String sql = "SELECT opens FROM hours WHERE day = '" + day + "'";
		try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(sql)) {
			if (rs.next())
				return rs.getInt("opens");
		}
		return -1;
	}

	public static int getOpening2(Connection conn, String day) throws SQLException {
		String sql = "SELECT opens FROM hours WHERE day = '" + day + "'";
		try (var stmt = conn.prepareStatement(sql); var rs = stmt.executeQuery()) {
			if (rs.next())
				return rs.getInt("opens");
		}
		return -1;
	}

	public static int getOpening3(Connection conn, String day) throws SQLException {
		String sql = "SELECT opens FROM hours WHERE day = ?";
		try (var ps = conn.prepareStatement(sql)) {
			ps.setString(1, day);
			try (var rs = ps.executeQuery()) {
				if (rs.next())
					return rs.getInt("opens");
			}
		}
		return -1;
	}

}
