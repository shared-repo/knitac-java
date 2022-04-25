import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 데이터베이스 연동 기능을 수행하는 클래스 ( JDBC 코드 사용 )
public class HRDao {
	
	// key를 사용해서 데이터 조회 + 조회 결과를 EmployeeDto에 담아서 반환
	public List<EmployeeDto> selectEmployeesByNameKey(String key) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// 조회 결과를 저장할 컬렉션 객체 ( 조회 결과가 여러 개일 수 있기 때문에 )
		ArrayList<EmployeeDto> employees = new ArrayList<>();
		
		try {
			// 1. JDBC 드라이버 준비
			// DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.OracleDriver");			
			
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"hr", "hr"); // 계정 정보
			
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "select employee_id, first_name, last_name, email " +
						 "from employees " +
						 "where    lower(first_name) like ? " + // ? : 데이터가 들어올 자리
						 "      or lower(last_name)  like ? ";			
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, "%" + key + "%"); // SQL의 1번째 ?에 사용될 데이터
			pstmt.setString(2, "%" + key + "%"); // SQL의 2번째 ?에 사용될 데이터			
			
			// 4. 명령 실행 ( select인 경우 ResultSet 형식의 결과 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
			
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) { // 결과 집합의 다음 행으로 이동 (더이상 행이 없으면 false 반환)
				EmployeeDto employee = new EmployeeDto(); 	// 한 행마다 Dto 객체 만들어서
				employee.setEmployeeId(rs.getInt(1));		// 행의 데이터를 Dto 객체에 저장
				employee.setFirstName(rs.getString("first_name"));
				employee.setLastName(rs.getString(3));
				employee.setEmail(rs.getString(4));
				
				employees.add(employee); // 한 행의 데이터를 저장한 Dto객체를 목록에 추가
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return employees; // 조회 결과를 저장한 컬렉션 객체를 호출한 곳으로 반환
	}

}
