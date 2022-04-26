import java.util.List;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		// 사용자 입력 ( UI 영역 코드 )
		Scanner scanner = new Scanner(System.in);
		System.out.print("검색할 직원 이름 : ");
		String key = scanner.nextLine();
		
		// 데이터 조회 : Dao 객체에게 요청
		HRDao dao = new HRDao();
		List<EmployeeDto> employees = dao.selectEmployeesByNameKey(key);
		
		// 결과 표시 ( UI 영역 코드 )
		for (EmployeeDto employee : employees) {
			System.out.printf("[%d][%15s][%15s][%s]\n", 
							  employee.getEmployeeId(), 
							  employee.getFirstName(),
							  employee.getLastName(),
							  employee.getEmail());
		}
		
		scanner.close();
			
		

	}

}
