package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;
import com.demoweb.dto.Member;

import lombok.Setter;

public class BoardDaoWithJdbcTemplate implements BoardDao {
	
	@Setter
	private JdbcTemplate jdbcTemplate;

	@Override
	public void insertBoard(Board board) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder(); // 자동 증가된 컬럼의 데이터를 받는 변수
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into board (title, writer, content) values (?, ?, ?)";
				PreparedStatement pstmt = 
						con.prepareStatement(sql, new String[] { "boardno" }); // insert 실행 후 조회할 새로 삽입된 행의 특정 컬럼 지정
				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContent());
			
				return pstmt;
			}
		}, keyHolder); // 자동 증가값 저장
		
		board.setBoardNo(keyHolder.getKey().intValue());
		System.out.println(board.getBoardNo());
		
	}

	@Override
	public List<Board> selectAll() {
			
		// 3. SQL 작성 + 명령 객체 만들기
		String sql = "select boardno, title, writer, readcount, regdate, deleted " +
					 "from board " +
					 "order by boardno desc"; // 최근에 작성된 글을 앞에 표시

		List<Board> boardList = jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				board.setRegDate(rs.getDate(5));
				board.setDeleted(rs.getBoolean(6));
				return board;
			}
		});
			
		return boardList;
	}

	@Override
	public List<Board> selectByRange(HashMap<String, Object> params) {
		String sql = "select boardno, title, writer, readcount, regdate, deleted " +
					 "from board " +
					 "order by boardno desc " + // 최근에 작성된 글을 앞에 표시
					 "limit ?, ?";
		
		List<Board> boardList = jdbcTemplate.query(sql, new RowMapper<Board>() {

			@Override
			public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
				Board board = new Board();
				board.setBoardNo(rs.getInt(1));
				board.setTitle(rs.getString(2));
				board.setWriter(rs.getString(3));
				board.setReadCount(rs.getInt(4));
				board.setRegDate(rs.getDate(5));
				board.setDeleted(rs.getBoolean(6));
				return board;
			}
			
		}, params.get("from"), params.get("count"));
			
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
			
		String sql = "select count(*) from board ";

		int count = jdbcTemplate.queryForObject(sql, new RowMapper<Integer>() {

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				return rs.getInt(1);
			}
			
		});
			
		return count;
	}
	
	//////////////////////////////////////////
	
	@Override
	public void insertBoardAttach(BoardAttach attach) {

		String sql = 
			"insert boardattach " +
			"(boardno, userfilename, savedfilename) " +
			"VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, attach.getBoardNo(), attach.getUserFileName(), attach.getSavedFileName());
		
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
