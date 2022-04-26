import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class LottoDao {
	
	// 로또 당첨번호 데이터를 받아서 데이터베이스에 저장하고 영향 받은 행의 갯수를 반환
	public int insertWinningNumbers(WinningNumbersDto dto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		int count = 0; // SQL 실행에 영향을 받은 행의 갯수 저장 변수
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "insert into winning_numbers " +
						 "values (?, ?, ?, ?, ?, ?, ?, ?)";			
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setInt(1, dto.getRound()); 	// SQL의 1번째 ?에 사용될 데이터
			pstmt.setInt(2, dto.getNo1()); 		// SQL의 2번째 ?에 사용될 데이터
			pstmt.setInt(3, dto.getNo2()); 		// SQL의 3번째 ?에 사용될 데이터
			pstmt.setInt(4, dto.getNo3()); 		// SQL의 4번째 ?에 사용될 데이터
			pstmt.setInt(5, dto.getNo4()); 		// SQL의 5번째 ?에 사용될 데이터
			pstmt.setInt(6, dto.getNo5()); 		// SQL의 6번째 ?에 사용될 데이터
			pstmt.setInt(7, dto.getNo6()); 		// SQL의 7번째 ?에 사용될 데이터
			pstmt.setInt(8, dto.getBonusNo()); 	// SQL의 8번째 ?에 사용될 데이터
			
			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
			count = pstmt.executeUpdate(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리			
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		
		return count;		
	}

}
