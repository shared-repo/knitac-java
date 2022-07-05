package com.demoweb.service;

import java.util.HashMap;
import java.util.List;

import com.demoweb.dao.BoardCommentDao;
import com.demoweb.dao.BoardDao;
import com.demoweb.dao.BoardDaoWithJdbcTemplate;
import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;
import com.demoweb.dto.BoardComment;
import com.demoweb.mapper.BoardMapper;

import lombok.Setter;

public class BoardServiceImpl implements BoardService {

	@Setter
	private BoardDao boardDao;
	
	@Setter
	private BoardMapper boardMapper; // Spring Mybatis가 자동으로 생성한 DAO 주입
	
	@Override
	public void writeBoard(Board board) {
		
		// 게시물 데이터를 DB에 저장
		// c1. 이 위치에서 boardNo : 없음
		// boardDao.insertBoard(board); // c1., c2. 를 반영해서 insertBoard에서 boardNo 조회하도록 구현
		boardMapper.insertBoard(board);
		// c2. 이 위치에서 boardNo : 데이터베이스에 있음 ( 데이터베이스의 boardNo를 조회할 필요 있음 )
		
		// 첨부파일 데이터를 DB에 저장
		if (board.getFiles() != null) {
			for (BoardAttach file : board.getFiles()) {
				file.setBoardNo(board.getBoardNo()); // insertBoard 실행할 때 조회된 자동증가 boardNo 사용
				// boardDao.insertBoardAttach(file);
				boardMapper.insertBoardAttach(file);
			}
		}
		
	}

	@Override
	public List<Board> findAll() {

		// List<Board> boardList = boardDao.selectAll();
		List<Board> boardList = boardMapper.selectAll();
		return boardList;
	}
	
	@Override
	public List<Board> findByPage(int pageNo, int pageSize) {
		
		int from = (pageNo - 1) * pageSize;
		int count = pageSize;
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("from", from);
		params.put("count", count);
		
		// List<Board> boardList = boardDao.selectByRange(params);
		List<Board> boardList = boardMapper.selectByRange(params);
		
		return boardList;
	}

	@Override
	public Board findByBoardNo(int boardNo) {
		
		// Board board = boardDao.selectByBoardNo(boardNo); // 게시물 데이터 조회
		Board board = boardMapper.selectByBoardNo(boardNo); // 게시물 데이터 조회
		
		// List<BoardAttach> files = boardDao.selectBoardAttachByBoardNo(boardNo);	// 첨부 파일 데이터 조회
		List<BoardAttach> files = boardMapper.selectBoardAttachByBoardNo(boardNo);	// 첨부 파일 데이터 조회
		board.setFiles(files);
		
		// boardDao.updateBoardReadCount(boardNo);
		boardMapper.updateBoardReadCount(boardNo);
		board.setReadCount(board.getReadCount() + 1);
		
		return board;
	}

	@Override
	public void delete(int boardNo) {
		
		// boardDao.delete(boardNo);
		boardMapper.delete(boardNo);
		
	}

	@Override
	public void update(Board board) {

		// boardDao.update(board);
		boardMapper.update(board);
		
	}

	@Override
	public int findBoardCount() {
		// int count = boardDao.selectBoardCount();
		int count = boardMapper.selectBoardCount();
		return count;
	}

	@Override
	public BoardAttach findBoardAttachByAttachNo(int attachNo) {
		// BoardAttach attach = boardDao.selectBoardAttachByAttachNo(attachNo);
		BoardAttach attach = boardMapper.selectBoardAttachByAttachNo(attachNo);
		return attach;
	}
	
	/////////////////////////////////////////////////////////////////////////

	private BoardCommentDao boardCommentDao = new BoardCommentDao();
	
	@Override
	public void writeBoardComment(BoardComment comment) {
		
		boardCommentDao.insertBoardComment(comment);
		
	}

	@Override
	public List<BoardComment> findCommentsByBoardNo(int boardNo) {
		List<BoardComment> comments = boardCommentDao.selectByBoardNo(boardNo);
		return comments;
	}

	@Override
	public void deleteComment(int commentNo) {
		boardCommentDao.delete(commentNo);
	}

	@Override
	public void updateBoardComment(BoardComment comment) {
		boardCommentDao.update(comment);
		
	}



}












