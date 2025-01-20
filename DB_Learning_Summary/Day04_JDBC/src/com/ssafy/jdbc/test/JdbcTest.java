package com.ssafy.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;

public class JdbcTest {

	public JdbcTest() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로딩 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		JdbcTest db = new JdbcTest(); // 이제는 알아야해~!
		
		for(Board b : db.selectAll()) {
			System.out.println(b);
		}
	}

	private List<Board> selectAll() {
		
		List<Board> list = new ArrayList<>();
		// 데이터 베이스 연결도 하고 데이터를 가지고 오면 된다.
		try {
			 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ssafy_board?serverTimezone=UTC","minsu", "1234");
			 
			 Statement stmt = conn.createStatement();
			 
			 String sql = "SELECT * FROM board"; // 게시글을 전체 조회하는 SQL문
			 
			 ResultSet rs = stmt.executeQuery(sql);
			 
			 while(rs.next()) {
				 Board board = new Board(); // 빈 바구니를 하나 생성
				 board.setId(rs.getInt("id")); // 라벨
				 board.setWriter(rs.getString("writer"));
				 board.setTitle(rs.getString("title"));
				 board.setContent(rs.getString("content"));
				 board.setViewCnt(rs.getInt("view_cnt"));
				 board.setRegDate(rs.getString("reg_date"));
				 list.add(board);
			 }
			 
			 rs.close();
			 stmt.close();
			 conn.close();
			 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return list;
		
	}

}
