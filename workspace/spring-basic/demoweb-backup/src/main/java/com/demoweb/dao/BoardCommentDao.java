package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.demoweb.dto.Board;
import com.demoweb.dto.BoardAttach;
import com.demoweb.dto.BoardComment;
import com.demoweb.dto.Member;

public class BoardCommentDao {

	public void insertBoardComment(BoardComment boardComment) {
		
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");			
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", // db server url
					"knit", "mysql"); // 계정 정보
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "insert into boardcomment (boardno, writer, content, groupno, step, depth) " +
						 "values (?, ?, ?, 0, 1, 0)";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			
			pstmt.setInt(1, boardComment.getBoardNo());
			pstmt.setString(2, boardComment.getWriter());
			pstmt.setString(3, boardComment.getContent());
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			pstmt.executeUpdate(); // executeQuery : select, exeucteUpdate : select 이외의 sql
						
			// 자동 증가 컬럼값 조회를 위한 sql 실행
			sql = "select last_insert_id()"; // oracle : select sequence.currval from dual
			pstmt2 = conn.prepareStatement(sql);
			rs = pstmt2.executeQuery();
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			rs.next();
			int newCommentNo = rs.getInt(1);
			boardComment.setCommentNo(newCommentNo);
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { pstmt2.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
	}

	public List<BoardComment> selectByBoardNo(int boardNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardComment> commentList = new ArrayList<>(); // 조회 결과를 저장할 변수
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", // db server url
					"knit", "mysql"); // 계정 정보
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "select commentno, boardno, writer, content, regdate, deleted, groupno, step, depth " +
						 "from boardcomment " +
						 "where boardno = ? and deleted = false " +
						 "order by commentno desc"; // 최근에 작성된 글을 앞에 표시
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setInt(1, boardNo);
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) { 
				BoardComment comment = new BoardComment();
				comment.setCommentNo(rs.getInt(1));
				comment.setBoardNo(rs.getInt(2));
				comment.setWriter(rs.getString(3));
				comment.setContent(rs.getString(4));
				comment.setRegDate(rs.getDate(5));
				comment.setDeleted(rs.getBoolean(6));
				comment.setGroupNo(rs.getInt(7));
				comment.setStep(rs.getInt(8));
				comment.setDepth(rs.getInt(9));
				commentList.add(comment);
			}
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return commentList;
	}

	public List<BoardComment> selectByRange(int from, int count) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardComment> commentList = new ArrayList<>(); // 조회 결과를 저장할 변수
		
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");			
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", // db server url
					"knit", "mysql"); // 계정 정보
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "select commentno, boardno, writer, content, regdate, deleted, groupno, step, depth " +
						 "from boardcomment " +
						 // "order by boardno desc " + // 최근에 작성된 글을 앞에 표시
						 "limit ?, ?";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setInt(1, from);
			pstmt.setInt(2, count);
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) { 
				BoardComment comment = new BoardComment();
				comment.setCommentNo(rs.getInt(1));
				comment.setBoardNo(rs.getInt(2));
				comment.setWriter(rs.getString(3));
				comment.setContent(rs.getString(4));
				comment.setRegDate(rs.getDate(5));
				//comment.setDeleted(rs.getBoolean(6));
				comment.setGroupNo(rs.getInt(7));
				comment.setStep(rs.getInt(8));
				comment.setDepth(rs.getInt(9));
				commentList.add(comment);
			}
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return commentList;
	}
	
	public void delete(int commentNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");			
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", // db server url
					"knit", "mysql"); // 계정 정보
			
			// 3. SQL 작성 + 명령 객체 만들기
			// String sql = "delete from board where boardno = ?";
			String sql = "update boardcomment set deleted = true where commentno = ?";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setInt(1, commentNo);
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			pstmt.executeUpdate(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	public void update(BoardComment comment) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");			
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", // db server url
					"knit", "mysql"); // 계정 정보
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "update boardcomment " +
						 "set content = ? " +
						 "where commentno = ?";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, comment.getContent());
			pstmt.setInt(2, comment.getCommentNo());
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			pstmt.executeUpdate(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
	}

	public int selectCommentCount() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0; // 조회 결과를 저장할 변수
		
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver");			
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demoweb", // db server url
					"knit", "mysql"); // 계정 정보
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "select count(*) from boardcomment ";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			rs.next(); // 언제나 결과가 있는 조회이기 때문에 if 또는 while 생략
			count = rs.getInt(1);
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return count;
	}
	
}
