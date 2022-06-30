package com.demoweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;

import lombok.Setter;

public class BoardDaoWithMyBatis implements BoardDao {
	
	@Setter
	private JdbcTemplate jdbcTemplate;
	
	@Setter
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String BOARD_MAPPER = "com.demoweb.mapper.BoardMapper";

	@Override
	public void insertBoard(Board board) {
		sqlSessionTemplate.insert(BOARD_MAPPER + ".insertBoard", board);
	}

	@Override
	public List<Board> selectAll() {

		List<Board> boardList = 
				sqlSessionTemplate.selectList(BOARD_MAPPER + ".selectAll");
			
		return boardList;
	}

	@Override
	public List<Board> selectByRange(HashMap<String, Object> params) {
				
		List<Board> boardList = 
			sqlSessionTemplate.selectList(BOARD_MAPPER + ".selectByRange", params);
		return boardList;
	}
	
	@Override
	public Board selectByBoardNo(int boardNo) {
		
		Board board = 
			sqlSessionTemplate.selectOne(BOARD_MAPPER + ".selectByBoardNo", boardNo);
		return board;
		
	}
	
	@Override
	public void updateBoardReadCount(int boardNo) {
		sqlSessionTemplate.update(BOARD_MAPPER + ".updateBoardReadCount", boardNo);
	}

	@Override
	public void delete(int boardNo) {
		
		sqlSessionTemplate.delete(BOARD_MAPPER + ".delete", boardNo);
			
	}

	@Override
	public void update(Board board) {
		sqlSessionTemplate.update(BOARD_MAPPER + ".update", board);
	}

	@Override
	public int selectBoardCount() {
			
		int count = sqlSessionTemplate.selectOne(BOARD_MAPPER + ".selectBoardCount");
		return count;
	}
	
	//////////////////////////////////////////
	
	@Override
	public void insertBoardAttach(BoardAttach attach) {

		sqlSessionTemplate.insert(BOARD_MAPPER + ".insertBoardAttach", attach);
		
	}

	@Override
	public List<BoardAttach> selectBoardAttachByBoardNo(int boardNo) {
		
		List<BoardAttach> files = 
			sqlSessionTemplate.selectList(BOARD_MAPPER + ".selectBoardAttachByBoardNo", boardNo);
		return files; //조회된 데이터를 저장한 객체 반환
	}

	@Override
	public BoardAttach selectBoardAttachByAttachNo(int attachNo) {
		
		BoardAttach file = 
			sqlSessionTemplate.selectOne(BOARD_MAPPER + ".selectBoardAttachByAttachNo", attachNo);
		
		return file; //조회된 데이터를 저장한 객체 반환
	}

	

}
