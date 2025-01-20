package com.ssafy.board.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	/**
	 * DB 접속에 필요한 url을 작성한다. url은
	 * jdbc:mysql://[host][:port]/[database][?propertyName1][=propertyValue1]
	 * serverTimezone=UTC 클라이언트와 서버 시간대 명시적으러 설정하는 옵션 UTC(Coordinate Universal Time,
	 * 협정 세계시)는 세계 시간 표준
	 */

	// DB와 연결하기 위해 필요한 DB의 URL
	private final String url = "jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC";
	// DB의 USER 이름
	private final String username = "minsu";
	// 위 USEr의 PASSWORD
	private final String password = "1234";
	// Mysql 드라이버 클래스 이름
	private final String driverName = "com.mysql.cj.jdbc.Driver";

	/**
	 * Singleton Design Pattern을 적용해준다.
	 */

	private static DBUtil instance = new DBUtil();

	private DBUtil() {

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static DBUtil getInstance() {
		return instance;
	}

	/**
	 * DriverManager를 통해 Connection을 생성하고 반환한다.
	 * 
	 * @return
	 * @throws SQLEXception
	 */
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	}
	
	// 종료
	// rs / stmt / conn ->
	
	/**
	 * 사용한 리소르들을 정리한다.
	 * Connection, Statement, Result Set 모두 AutoCloseable 타입이다.
	 * ...을 이용하므로 필요에 따라서
	 * select 계열 호출 후는 ResultSet, Statement, Connection
	 * dml 호출 후는 Statement, Connection 등 다양한 조합으로 사용할 수 있다.
	 * 
	 * @param closeables
	 */
	
	public void close(AutoCloseable... closeables) {
		
		for(AutoCloseable c : closeables) {
			
			if(c!= null) {
				
				try {
					c.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
	}
	
	 
}
