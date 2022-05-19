package com.demoweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.demoweb.dto.Member;

public class MemberDao {
	
	public void insertMember(Member member) {
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
			String sql = "insert into member (memberid, passwd, email) " +
						 "values (?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getPasswd());
			pstmt.setString(3, member.getEmail());
			
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

}
