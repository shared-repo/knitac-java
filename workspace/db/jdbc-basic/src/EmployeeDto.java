
// DTO : 데이터 전달을 위한 클래스, 
//       여기서는 데이터베이스의 Employee 테이블의 데이터 저장용
public class EmployeeDto {
	
	// 필드 선언 : Employees 테이블의 컬럼과 일치하도록 구현
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	// 나머지 컬럼은 생략
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
