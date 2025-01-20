package com.ssafy.board.test;

import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.dao.BoardDaoImpl;
import com.ssafy.board.model.dto.Board;

public class Test {
	
	public static void main(String[] args) {
		
		BoardDao dao = BoardDaoImpl.getInstance();
		
//		 아이디 한개 조회
		System.out.println(dao.selectOne(1));
		
		
		// insert
		Board board = new Board("이제는 알아야해01", "김민수", "U+ 취업할 것이다.");
		dao.insertBoard(board);
		
		
		// delete
		dao.deleteBoard(1);
	}
	
}
