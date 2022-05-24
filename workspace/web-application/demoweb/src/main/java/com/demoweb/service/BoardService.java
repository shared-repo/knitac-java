package com.demoweb.service;

import com.demoweb.dao.BoardDao;
import com.demoweb.dto.Board;

public class BoardService {

	private BoardDao boardDao = new BoardDao();
	
	public void writeBoard(Board board) {
		
		boardDao.insertBoard(board);
		
	}

}
