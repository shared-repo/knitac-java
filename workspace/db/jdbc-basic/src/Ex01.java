import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Ex01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"hr", "hr"); // 계정 정보
			
			// 3. SQL 작성 + 명령 객체 만들기
			String sql = "select employee_id, first_name, last_name, email from employees";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) {
				System.out.printf("[%d][%15s][%15s][%s]\n", 
								  rs.getInt(1), rs.getString(2), 
								  rs.getString(3), rs.getString(4));
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}

	}

}
