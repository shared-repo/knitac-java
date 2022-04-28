import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


// 연락처 테이블 생성 SQL
/*
create table contact
(
    no number(6) primary key,   -- 자동 증가 처리
    name varchar2(100) not null,
    phone varchar2(20) not null,
    email varchar2(50) null
);

create sequence contact_sequence nocache;
*/

//파일에 저장 또는 파일로부터 읽는 클래스는 Serialzable 인터페이스를 구현해야 합니다.
class Contact implements Serializable {
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

class Ex06ContactManager {
	
	ContactDao dao = new ContactDao();

	java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	ArrayList<Contact> contacts = null; // 생성자 메서드에서 초기화하도록 변경
	
	// 다음에 등록할 연락처의 생성 순서 번호 저장할 변수
	int nextIdx = 1;
	
	public Ex06ContactManager() { // 생성자 메서드 : 초기화, 인스턴스가 만들어질때 자동 호출
	}
	
	public void doManage() {
				
		while (true) { // 메뉴표시 - 선택에 따라 실행 반복
			String selection = selectMenu();
			
			System.out.println(); // 앞쪽 여백
			if (selection.equals("7")) {
				System.out.println(">>> 프로그램이 종료됩니다");
				break;
			} else if (selection.equals("1")) { 		// 등록
				ContactDto contact = inputContact();	// 입력				
				dao.insertContact(contact);
				System.out.println(">>> 새 연락처를 등록했습니다");
			} else if (selection.equals("2")) { 		// 수정
				// 1. 입력, 2. 검색, 3. 검색 결과 표시
				System.out.print("수정할 연락처 이름 : ");
				String nameKey = scanner.nextLine();
				List<ContactDto> contacts = dao.selectContactsByName(nameKey);
				if (contacts.size() == 0) { // 검색 결과가 없는 경우
					System.out.println("[ 검색된 연락처가 없습니다 ]");
				} else {
					System.out.println("[ 연락처 목록 ]");
					for (ContactDto contact : contacts) {
						System.out.println(contact.info());
					}
				}
				// 4. 수정 대상 선택 ( 번호 입력 )
				// 5. 수정 내용 입력 ( 이름, 전화번호, 이메일 )
				// 6. 수정 실행
				
			} else if (selection.equals("3")) { 		// 삭제
				// 1. 입력, 2. 검색, 3. 검색 결과 표시
				System.out.print("삭제할 연락처 이름 : ");
				String nameKey = scanner.nextLine();
				List<ContactDto> contacts = dao.selectContactsByName(nameKey);
				if (contacts.size() == 0) { // 검색 결과가 없는 경우
					System.out.println("[ 검색된 연락처가 없습니다 ]");
				} else {
					System.out.println("[ 연락처 목록 ]");
					for (ContactDto contact : contacts) {
						System.out.println(contact.info());
					}
					// 4. 삭제 대상 선택 ( 번호 입력 )
					System.out.print("삭제할 연락처 번호 : ");
					int no = scanner.nextInt(); // 입력 buffer에 enter가 남아 있어서
					scanner.nextLine(); // buffer에 남아있는 enter 제거 
					// 5. 선택된 대상 삭제
					dao.deleteContact(no);
					System.out.println(">>> 선택된 연락처를 삭제했습니다.");
				}
			} else if (selection.equals("4")) { 		// 목록보기
				List<ContactDto> contacts = dao.selectAllContacts();
				System.out.println("[ 연락처 목록 ]");
				for (ContactDto contact : contacts) {
					System.out.println(contact.info());
				}				
			} else if (selection.equals("5")) { 		// 검색
				System.out.print("검색할 이름 : ");
				String nameKey = scanner.nextLine();
				List<ContactDto> contacts = dao.selectContactsByName(nameKey);
				System.out.println("[ 연락처 목록 ]");
				for (ContactDto contact : contacts) {
					System.out.println(contact.info());
				}			
			} else {
				System.out.println(">>> 지원하지 않는 기능입니다.");
			}
			System.out.println(); // 뒤쪽 여백
		}

	}

	private void showAllContacts() {
		System.out.println("[ 연락처 목록 ]");
		for (int i = 0; i < contacts.size(); i++) {
			Contact contact = contacts.get(i);
			System.out.println(contact.info());
		}
//		for (Contact contact : contacts) {
//			System.out.println(contact.info());
//		}
	}

	private ContactDto inputContact() {
		ContactDto contact = null; // 새로 등록할 연락처에 대한 참조 변수 ( 부모타입으로 선언 )
		// 입력 
		System.out.println("[ 등록할 연락처 정보 ]");
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		System.out.print("이메일 : ");
		String email = scanner.nextLine();
		
		contact = new ContactDto(0, name, phone, email);
		return contact;
	}

	

	private String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 연락처 등록                *");
		System.out.println("* 2. 연락처 수정                *");
		System.out.println("* 3. 연락처 삭제                *");
		System.out.println("* 4. 연락처 목록                *");
		System.out.println("* 5. 연락처 검색                *");
		System.out.println("* 6. 연락처 저장                *");
		System.out.println("* 7. 종료                      *");
		System.out.println("******************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		return selection;
	}

	public static void main(String[] args) {
		
		Ex06ContactManager manager = new Ex06ContactManager();
		manager.doManage();

	}
 
}










