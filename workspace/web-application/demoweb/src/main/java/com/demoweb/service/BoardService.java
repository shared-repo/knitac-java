package com.demoweb.service;

import java.util.List;

import com.demoweb.dao.BoardDao;
import com.demoweb.dto.Board;

public class BoardService {

	private BoardDao boardDao = new BoardDao();
	
	public void writeBoard(Board board) {
		
		boardDao.insertBoard(board);
		
	}

	public List<Board> findAll() {

		List<Board> boardList = boardDao.selectAll();
		return boardList;
	}

	public Board findByBoardNo(int boardNo) {
		
		Board board = boardDao.selectByBoardNo(boardNo);
		return board;
	}

	public void delete(int boardNo) {
		
		boardDao.delete(boardNo);
		
	}

	public void update(Board board) {

		boardDao.update(board);
		
	}

}












