
// 연락처 관리 --> 연락처 클래스 : 업무연락처클래스, 개인연락처클래스
// 업무연락처 : 연락처번호(정수), 이름(문자열), 전화번호(문자열), 이메일(문자열), 회사(문자열), 직함(문자열)
// 개인연락처 : 연락처번호(정수), 이름(문자열), 전화번호(문자열), 이메일(문자열), 관계(문자열), 생일(문자열)

// 1. 클래스 만들기
//    연락처클래스(Contact), 업무연락처클래스(BizContact), 개인연락처클래스(PersonalContact)
//    업무연락처클래스와 개인연락처클래스는 연락처클래스 상속

class Contact {
	private int no;
	private String name;
	private String phone;
	private String email;

	public Contact() {}	
	public Contact(int no, String name, String phone, String email) {
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

class BizContact extends Contact {
	private String company;
	private String title;
	
	public BizContact() {}
	
	public BizContact(int no, String name, String phone, String email, 
					  String company, String title) {
		super(no, name, phone, email); // 부모 클래스의 생성자 호출
		this.company = company;
		this.title = title;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String info() {
		String info = super.info(); // super : 부모클래스의 멤버를 명시적으로 표시할 때 사용
		return String.format("%s[%s][%s]", info, company, title);
	}
}

class PersonalContact extends Contact {
	private String relation;
	private String birth;
	
	public PersonalContact() {}
	
	public PersonalContact(int no, String name, String phone, String email, 
						   String relation, String birth) {
		super(no, name, phone, email); // 부모 클래스의 생성자 메서드 호출
		this.relation = relation;
		this.birth = birth;
	}

	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String info() {
		String info = super.info(); // super : 부모클래스의 멤버를 명시적으로 표시할 때 사용
		return String.format("%s[%s][%s]", info, relation, birth);
	}
}

public class OOP13 {

	static java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	public static void main(String[] args) {
		
		// testMethod1();
		
		while (true) { // 메뉴표시 - 선택에 따라 실행 반복
			String selection = selectMenu();			
			// System.out.println(selection);
			
			System.out.println(); // 앞쪽 여백
			if (selection.equals("6")) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			} else if (selection.equals("1")) {
				// 입력 
				System.out.println("[ 등록할 연락처 정보 ]");
				System.out.print("종류 (1-개인연락처, 2-업무연락처) : ");
				String type = scanner.nextLine();
				System.out.print("이름 : ");
				String name = scanner.nextLine();
				System.out.print("전화번호 : ");
				String phone = scanner.nextLine();
				System.out.print("이메일 : ");
				String email = scanner.nextLine();
				if (type.equals("1")) { // 개인연락처인 경우
					System.out.print("관계 : ");
					String relation = scanner.nextLine();
					System.out.print("생일 : ");
					String birth = scanner.nextLine();
					PersonalContact contact = new PersonalContact(0, name, phone, email, relation, birth);
					System.out.println(contact.info());
				} else { // 업무연락처인 경우
					System.out.print("회사 : ");
					String company = scanner.nextLine();
					System.out.print("직함 : ");
					String title = scanner.nextLine();
					BizContact contact = new BizContact(0, name, phone, email, company, title);
					System.out.println(contact.info());
				}
				
			} else {
				System.out.println("지원하지 않는 기능입니다.");
			}
			System.out.println(); // 뒤쪽 여백
		}

	}

	private static String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 연락처 등록                *");
		System.out.println("* 2. 연락처 수정                *");
		System.out.println("* 3. 연락처 삭제                *");
		System.out.println("* 4. 연락처 목록                *");
		System.out.println("* 5. 연락처 검색                *");
		System.out.println("* 6. 종료                      *");
		System.out.println("******************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		return selection;
	}

	private static void testMethod1() {
		int a;
		a = 10;
		PersonalContact personalContact = new PersonalContact();
		personalContact.setNo(1);
		personalContact.setName("장동건");
		personalContact.setPhone("010-9098-3345");
		personalContact.setEmail("jdk@example.com");
		personalContact.setRelation("Friend");
		personalContact.setBirth("04-11");		
		System.out.println( personalContact.info() );
		
		int a2 = 20; // 초기화
		PersonalContact personalContact2 = 
				new PersonalContact(1, "장동건2", "010-9098-3345", "jdk2@example.com", "Friend", "04-11");
		System.out.println( personalContact2.info() );
		
		BizContact bizContact = new BizContact();
		bizContact.setNo(2);
		bizContact.setName("송강호");
		bizContact.setPhone("010-5214-5698");
		bizContact.setEmail("skh@example.com");
		bizContact.setCompany("써브라임");
		bizContact.setTitle("배우");
		
		System.out.println( bizContact.info() );
	}

}










