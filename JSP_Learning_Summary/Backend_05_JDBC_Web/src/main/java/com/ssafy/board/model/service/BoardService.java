package com.ssafy.board.model.service;

import java.util.List;

import com.ssafy.board.model.dto.Board;

public interface BoardService {

	public List<Board> getList();

	public Board getBoard(int id);

	public void writeBoard(Board board);

	public void modifyBoard(Board board);

	public void removeBoard(int id);
	
}
