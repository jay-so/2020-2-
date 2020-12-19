package management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//DB 연결 설정 및 해제
public class DBConnManager {
	static String dbServerAddr = "jdbc:mysql://localhost:3306/";  ////Db연결시 serverTime 오류 발생시 ?serverTimezone=UTC 추가
	static String dbName = "java?serverTimezone=UTC"; // DB명
	static String user = "root"; // 계정 명
	static String pswd = "1234"; // 비밀번호 명
	
	// DB 연결 설정
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbServerAddr + dbName, user, pswd);
	}
	
	public static Connection getConnection(String dbName) throws SQLException {
		return DriverManager.getConnection(dbServerAddr + dbName, user, pswd);
	}
	
	// DB 연결 해제
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null)
			conn.close();
	}
}
