
public class Ex04ControlStatement6 {

public static void main(String[] args) {
		
		//계산기 만들기
		//- 숫자, 연산자, 숫자를 순차적으로 입력
		//- 연산자에 따라 연산
		//- 출력
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.print("숫자: ");
		int operand1 = scanner.nextInt();
		System.out.print("연산자: ");
		String op = scanner.next(); // 문자열 입력
		System.out.print("숫자: ");
		int operand2 = scanner.nextInt();
		
//		System.out.println(operand1);
//		System.out.println(op);
//		System.out.println(operand2);
		
		//문자열을 비교할 때는 == 연산자 대신 equals 사용
		switch (op) { // 정수 계열 + 문자열만 사용
		case "+": 
			System.out.println(operand1 + operand2);
			break; // switch-case 문을 종료하는 명령
		case "-":
			System.out.println(operand1 - operand2);
			break; 
		case "*":
			System.out.println(operand1 * operand2);
			break; 
		case "/":
			System.out.println(operand1 / operand2);
			System.out.println( (double)operand1 / operand2 );
			break; 
		case "%":
			System.out.println(operand1 % operand2);
			break; 
		default: // 위 case에 해당하지 않는 모든 경우
			System.out.println("지원하지 않는 연산자입니다.");
		}
		
		scanner.close();
	}
	
}
