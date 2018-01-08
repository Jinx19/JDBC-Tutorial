package net.tan.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcOperation {
	String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/mac?user=root&password=123456";
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

	public void insertData() {
		if (conn == null) {
			initDatabase();
		}
		String sql = "INSERT INTO student_status " + "(idstudent_status,name,sex,bir,`add`) VALUES "
				+ "('2037130877','huangjue','m','19840308','Hubei WuHan')";
		try {
			Statement myStmt = conn.createStatement();
			myStmt.executeUpdate(sql);

			System.out.println("Insert complete");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateData() {
		if (conn == null) {
			initDatabase();
		}
		String sql = "UPDATE student_status set `add` = 'Bei Jing' WHERE name = 'wangwei'";
		try {
			conn.createStatement().executeUpdate(sql);
			System.out.println("Update complete");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteData() {
		if (conn == null) {
			initDatabase();
		}
		String sql = "DELETE from student_status where name = 'tnjin'";
		try {
			Statement myStmt = conn.createStatement();

			int rowsAffected = myStmt.executeUpdate(sql);
			System.out.println("Delete complete");
			System.out.println(rowsAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void selectData() {
		if (conn == null) {
			initDatabase();
		}
		String sql = "SELECT * from student_status where name = 'wuwei'";
		try {
			Statement myStmt = conn.createStatement();

			ResultSet myRs = myStmt.executeQuery(sql);
			while (myRs.next()) {
				System.out.println("select result:");
				System.out.println(myRs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void closeDatabase() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
