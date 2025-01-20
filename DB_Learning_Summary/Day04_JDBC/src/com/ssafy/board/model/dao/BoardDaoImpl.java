package com.ssafy.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub

	}

}
