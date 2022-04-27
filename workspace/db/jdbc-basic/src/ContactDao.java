import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {

	public void insertContact(ContactDto contact) {
		
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
			String sql = "insert into contact (no, name, phone, email) " +
						 "values (contact_sequence.nextval, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			
			pstmt.setString(1, contact.getName()); 		// SQL의 1번째 ?에 사용될 데이터
			pstmt.setString(2, contact.getPhone()); 	// SQL의 2번째 ?에 사용될 데이터
			pstmt.setString(3, contact.getEmail()); 	// SQL의 3번째 ?에 사용될 데이터
				
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
	
	public List<ContactDto> selectAllContacts() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactDto> contacts = new ArrayList<>();

		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "select no, name, phone, email " +
						 "from contact ";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			
			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
				
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) {
				ContactDto contact = new ContactDto(rs.getInt(1), 
													rs.getString(2), 
													rs.getString(3), 
													rs.getString(4));
				contacts.add(contact);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return contacts;
		
	}

	public List<ContactDto> selectContactsByName(String nameKey) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<ContactDto> contacts = new ArrayList<>();

		try {
			// 1. JDBC 드라이버 준비
			Class.forName("oracle.jdbc.OracleDriver");
			// 2. 데이터베이스에 연결 ( 연결 객체 준비 )
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", // db server url
					"scott", "TIGER"); // 계정 정보
			// 3-2. SQL 작성 + 명령 객체 만들기 2 ( SQL과 데이터를 분리 )
			String sql = "select no, name, phone, email " +
						 "from contact " +
						 "where name like ? ";
			pstmt = conn.prepareStatement(sql); // 명령객체 만들기
			pstmt.setString(1, "%" + nameKey + "%");
			
			// 4. 명령 실행 ( DML인 경우 영향 받은 행의 갯수 반환 )
			rs = pstmt.executeQuery(); // executeQuery : select, exeucteUpdate : select 이외의 sql
				
			// 5. 결과가 있으면 (select 명령인 경우) 결과 처리
			while (rs.next()) {
				ContactDto contact = new ContactDto(rs.getInt(1), 
													rs.getString(2), 
													rs.getString(3), 
													rs.getString(4));
				contacts.add(contact);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지를 화면에 출력
		} finally {
			// 6. 연결 종료
			try { rs.close(); } catch (Exception ex) {}
			try { pstmt.close(); } catch (Exception ex) {}
			try { conn.close(); } catch (Exception ex) {}
		}
		
		return contacts;
	}

	
}
