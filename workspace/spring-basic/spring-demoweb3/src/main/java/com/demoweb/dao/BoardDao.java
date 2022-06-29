package com.demoweb.dao;

import java.util.HashMap;
import java.util.List;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;

public interface BoardDao {

	void insertBoard(Board board);

	List<Board> selectAll();

	List<Board> selectByRange(HashMap<String, Object> params);

	Board selectByBoardNo(int boardNo);

	void delete(int boardNo);

	void update(Board board);

	int selectBoardCount();

	void insertBoardAttach(BoardAttach attach);

	List<BoardAttach> selectBoardAttachByBoardNo(int boardNo);

	BoardAttach selectBoardAttachByAttachNo(int attachNo);

	void updateBoardReadCount(int boardNo);

}