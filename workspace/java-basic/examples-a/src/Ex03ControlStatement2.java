
public class Ex03ControlStatement2 {

	public static void main(String[] args) {
		
		// 1. 사용자 입력 처리기 만들기
		// int            x       = 10;
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// 2-1. 입력 메시지 표시
		System.out.print("(테스트) 숫자를 입력하세요 : ");
		// 2-2. 사용자 입력 대기 -> 사용자 입력 후 enter -> 입력된 데이터를 변수에 저장
		int number = scanner.nextInt();
		System.out.println("Your Number : " + number);
		
		///////////////////////////////////////////////////////////
		
		// 3. 가위 바위 보 게임 만들기		
		// 3-1. 사용자 입력 (가위 : 1, 바위 : 2, 보 : 3) -> 변수에 저장
		System.out.print("가위 : 1, 바위 : 2, 보 : 3 중 하나를 선택하세요 : ");
		int userNumber = scanner.nextInt();
		
		// 3-2. 컴퓨터 값 뽑기 ( Math.random() 사용해서 1 or 2 or 3 뽑기 ) -> 변수에 저장
		int computerNumber = (int)(Math.random() * 3) + 1;
		
		System.out.println(userNumber + " / " + computerNumber);
		
		// 3-3. 사용자 입력과 컴퓨터 값 비교해서 승, 무, 패 출력 ( if ~ else if ~ else )
		if ( (userNumber == 1 && computerNumber == 3) ||
			 (userNumber == 2 && computerNumber == 1) ||
			 (userNumber == 3 && computerNumber == 2) ) {
			System.out.println("당신이 이겼습니다.");
		} else if ( userNumber == computerNumber ) {
			System.out.println("비겼습니다.");
		} else {
			System.out.println("당신이 졌습니다.");
		}
		
		
		// 사용자 입력 처리기 종료 (닫기)
		scanner.close();

	}

}

/* 1. 논리곱 ( && )
 * true && true => true
 * true && false => false
 * false && true => false
 * false && false => false
 * 
 * 2. 논리합 ( || )
 * true || true => true
 * true || false => true
 * false || true => true
 * false || false => false
 */









