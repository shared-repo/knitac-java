package com.demoweb.service;

import java.util.List;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;
import com.demoweb.dto.BoardComment;

public interface BoardService {

	void writeBoard(Board board);
	List<Board> findAll();
	List<Board> findByPage(int pageNo, int pageSize);
	Board findByBoardNo(int boardNo);
	void delete(int boardNo);
	void update(Board board);
	int findBoardCount();
	BoardAttach findBoardAttachByAttachNo(int attachNo);
	

	void writeBoardComment(BoardComment comment);
	List<BoardComment> findCommentsByBoardNo(int boardNo);
	void deleteComment(int commentNo);
	void updateBoardComment(BoardComment comment);

}