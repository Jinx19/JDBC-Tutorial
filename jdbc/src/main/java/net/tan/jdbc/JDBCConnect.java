package net.tan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnect {
	String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/?user=root&password=123456";
	Connection conn = null;

	public void initDatabase() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(DATABASE_URL);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if (conn != null) {
			System.out.println("connect success!");
		}
	}
}
