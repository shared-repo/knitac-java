import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class Ex03 {

	public static void main(String[] args) {
		
		String key = "z";
		
		// 데이터 조회 : Dao 객체에게 요청
		HRDao dao = new HRDao();
		List<EmployeeDto> employees = dao.selectEmployeesByNameKey(key);
		
		// 결과 표시
		for (EmployeeDto employee : employees) {
			System.out.printf("[%d][%15s][%15s][%s]\n", 
							  employee.getEmployeeId(), 
							  employee.getFirstName(),
							  employee.getLastName(),
							  employee.getEmail());
		}
			
		

	}

}
