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
	public List<Board> selectByRange(int from, int count) {
		
		HashMap<String, Object> params = new HashMap<>();
		params.put("from", from);
		params.put("count", count);
		
		List<Board> boardList = 
			sqlSessionTemplate.selectList(BOARD_MAPPER + ".selectByRange", params);
		return boardList;
	}
	
	@Override
	public Board selectByBoardNo(int boardNo) {
			
		String sql = "select boardno, title, writer, content, readcount, regdate " +
					 "from board " +
					 "where boardno = ? and deleted = false";
		
		Board board = jdbcTemplate.queryForObject(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setContent(rs.getString(4)); // 추가
				board.setReadCount(rs.getInt(5));
				board.setRegDate(rs.getDate(6));
				
				return board;
			}
		}, boardNo);

		return board;
		
	}
	
	@Override
	public void updateBoardReadCount(int boardNo) {
		String sql = "update board set readcount = readcount + 1 where boardno = ?";
		jdbcTemplate.update(sql, boardNo);
	}

	@Override
	public void delete(int boardNo) {
		
		String sql = "update board set deleted = true where boardno = ?";
		jdbcTemplate.update(sql, boardNo);
			
	}

	@Override
	public void update(Board board) {
		String sql = "update board " +
					 "set title = ?, content = ? " +
					 "where boardno = ?";
		jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getBoardNo());
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
		
		String sql = 
				"select attachno, boardno, userfilename, savedfilename, downloadcount " +
				"FROM boardattach " +
				"WHERE boardno = ?";					
	
		List<BoardAttach> files = jdbcTemplate.query(sql, new RowMapper<BoardAttach>() {

			@Override
			public BoardAttach mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardAttach file = new BoardAttach();
				file.setAttachNo(rs.getInt(1));
				file.setBoardNo(rs.getInt(2));
				file.setUserFileName(rs.getString(3));
				file.setSavedFileName(rs.getString(4));
				file.setDownloadCount(rs.getInt(5));
				return file;
			}
			
		}, boardNo);
		
		return files; //조회된 데이터를 저장한 객체 반환
	}

	@Override
	public BoardAttach selectBoardAttachByAttachNo(int attachNo) {
		
		String sql = 
				"select attachno, boardno, userfilename, savedfilename, downloadcount " +
				"from boardattach " +
				"where attachno = ?";					
		
		BoardAttach file = jdbcTemplate.queryForObject(sql, new RowMapper<BoardAttach>() {

			@Override
			public BoardAttach mapRow(ResultSet rs, int rowNum) throws SQLException {
				BoardAttach file = new BoardAttach();
				file.setAttachNo(rs.getInt(1));
				file.setBoardNo(rs.getInt(2));
				file.setUserFileName(rs.getString(3));
				file.setSavedFileName(rs.getString(4));
				file.setDownloadCount(rs.getInt(5));
				return file;
			}
			
		}, attachNo);
		
		return file; //조회된 데이터를 저장한 객체 반환
	}

	

}
