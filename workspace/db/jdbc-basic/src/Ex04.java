import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {

		// 사용자 입력 ( UI 영역 코드 )
		Scanner scanner = new Scanner(System.in);		
		
		MemberDto member = new MemberDto();
		member.setMemberId("iamuserone");
		member.setPasswd("iamuserone");
		member.setEmail("iamuserone@example.com");
		
		// 데이터 저장 : Dao 객체에게 요청
		MemberDao dao = new MemberDao();
		dao.insertMember(member);
		
		System.out.println("데이터를 데이터베이스에 저장했습니다.");
		
		
		scanner.close();
			
		

	}

}
