
public class ContactDto {
	private int no;
	private String name;
	private String phone;
	private String email;

	public ContactDto() {}	
	public ContactDto(int no, String name, String phone, String email) {
		// super(); // 부모 클래스의 생성자 메서드 호출
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String info() {
		return String.format("[%3d][%s][%s][%s]", no, name, phone, email);
	}
}
