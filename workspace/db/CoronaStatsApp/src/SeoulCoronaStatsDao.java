import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SeoulCoronaStatsDao {
	
	public void insertSeoulCoronaStats(List<SeoulCoronaStatsDto> stats) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "insert into seoul_corona_stats " +
						 "values (seoul_corona_stats_sequence.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
						
			for (SeoulCoronaStatsDto dto : stats) {
				pstmt.setString(1, dto.getRegDate()); 	// SQL의 1번째 ?에 사용될 데이터
				pstmt.setString(2, dto.getGuName()); 		// SQL의 2번째 ?에 사용될 데이터
				pstmt.setInt(3, dto.getTotal()); 		// SQL의 3번째 ?에 사용될 데이터
				pstmt.setInt(4, dto.getToday()); 		// SQL의 4번째 ?에 사용될 데이터
				
				// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
				pstmt.executeUpdate(); // executeQuery : select, exeucteUpdate : select 이외의 sql
				
				// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			}
	
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		
	}

	public void deleteAll() {
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "delete from seoul_corona_stats ";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기

			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
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

	public List<SeoulCoronaStatsDto> selectSeoulCoronaStatsByRegDate(String regDate) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<SeoulCoronaStatsDto> stats = new ArrayList<>();
		
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "select * " + 
						 "from seoul_corona_stats " + 
						 "where regdate = ?";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, regDate);

			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
				
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) {
				SeoulCoronaStatsDto dto = new SeoulCoronaStatsDto(
						rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getInt(4), rs.getInt(5));
				stats.add(dto);
			}

	
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return stats;
	}

	public List<SeoulCoronaStatsDto> selectSeoulCoronaStatsByGuName(String guName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<SeoulCoronaStatsDto> stats = new ArrayList<>();
		
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "select * " + 
						 "from seoul_corona_stats " + 
						 "where gu_name like ? " +
						 "order by regdate desc";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, guName + "%");

			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
				
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) {
				SeoulCoronaStatsDto dto = new SeoulCoronaStatsDto(
						rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getInt(4), rs.getInt(5));
				stats.add(dto);
			}

	
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return stats;
	}

	public List<SeoulCoronaStatsDto> selectMaxSeoulCoronaStats() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<SeoulCoronaStatsDto> stats = new ArrayList<>();
		
		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "select * " + 
						 "from seoul_corona_stats " + 
						 "where today = ( select max(today) from seoul_corona_stats ) ";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기

			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
				
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) {
				SeoulCoronaStatsDto dto = new SeoulCoronaStatsDto(
						rs.getInt(1), rs.getString(2),rs.getString(3), 
						rs.getInt(4), rs.getInt(5));
				stats.add(dto);
			}

	
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		return stats;
	}

}
