package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.board.model.dto.Board;
import com.ssafy.board.util.DBUtil;

public class BoardDaoImpl implements BoardDao {

	private DBUtil util = DBUtil.getInstance();

// 싱글턴으로 관리
//////////////////////////////////////////////////////////////
	private static BoardDao dao = new BoardDaoImpl();

	private BoardDaoImpl() {
	}

	public static BoardDao getInstance() {
		return dao;
	}

//////////////////////////////////////////////////////////////
	@Override
	public List<Board> selectAll() {
		
		List<Board> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board"; // 게시글을 전체 조회하는 SQL문
		// 데이터 베이스 연결도 하고 데이터를 가지고 오면 된다.
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			 
			 
			 rs = pstmt.executeQuery();
			 
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
			 pstmt.close();
			 conn.close();
			 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return list;
	}

	@Override
	public Board selectOne(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM board WHERE id = ?";
		Board board = null;
		
		
		try {
			conn = util.getConnection();

			// String sql = "SELECT * FROM board WHERE id =" + id; // 이런식으로 작성하거나...
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id); // 인덱스는 1부터 시작!

			rs = pstmt.executeQuery();
			board = new Board();
			while (rs.next()) {
				board.setId(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setTitle(rs.getString(3));
				board.setContent(rs.getString(4));
				board.setViewCnt(rs.getInt(5));
				board.setRegDate(rs.getString(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(rs, pstmt, conn);
		}
		
		
		//해당 id에 게시글 없어도... 껍데기를 만들어 두었다. 문법상 이슈는 없어서... 
		return board;
	}

	@Override
	public void insertBoard(Board board) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO board (title, writer, content) VALUES(?,?,?)";
		
		try {
			conn = util.getConnection();
			
			
//			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getWriter());
			pstmt.setString(3, board.getContent());
			
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result);
			
//			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void deleteBoard(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM board WHERE id = ?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			System.out.println(result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
	}

	@Override
	public void updateBoard(Board board) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE board SET title=?, content=? WHERE id = ?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getId());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}
		
	}

	@Override
	public void updateViewCnt(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE board SET view_cnt = view_cnt+1 WHERE id = ?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(pstmt, conn);
		}

	}

}
