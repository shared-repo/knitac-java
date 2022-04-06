
public class Ex04ControlStatement11 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		///////////////
		
		//1. while 연습
		while(true)	{
			//   50 ~ 150 범위의 정수를 2개 입력 받아서 각각 변수에 저장
			int number1 = 0;
			do {
				System.out.print("1. 50 ~ 150 범위의 정수 입력 : ");
				number1 = scanner.nextInt();
			} while (number1 < 50 || number1 >= 150); //입력이 비정상이면 다시 입력
			
			int number2 = 0;
			do {
				System.out.print("2. 50 ~ 150 범위의 정수 입력 : ");
				number2 = scanner.nextInt();
			} while (number2 < 50 || number2 >= 150);
			
			//   합과 평균을 계산해서 변수에 저장
			int sum = number1 + number2;
			int avg = sum / 2;
			//   출력	
			System.out.printf("[%d, %d][TOTAL : %d][AVG : %d]\n", number1, number2,sum, avg);		
			
			//   사용자에게 계속여부를 입력(y/n)받아서 반복하거나 중단 처리
			System.out.print("계속할까요(y/n)? ");
			String yn = scanner.next(); // nextLine과 차이를 비교
			// if (yn != "y") { // 비교연산자로 문자열을 비교할 수 없습니다.
			// if (yn.equals("y") == false) { // "y"가 아닌 경우
			// if (!yn.equals("y")) { // "y"가 아닌 경우
			// if (!yn.equals("y") && !yn.equals("Y")) { // "y"가 아닌 경우
			// if (!yn.equalsIgnoreCase("y")) { // equalsIgnoreCase : 대소문자 구분 없이 비교
			if (!yn.toLowerCase().equals("y")) { // toLowerCase : 소문자로 변경
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		///////////////
		scanner.close();
	}
}
/*
 * 논리연산자 - 논리부정
 * !true  -> false
 * !false -> true
 *
 * 사용자가 "y"를 입력 -> yn에 "y" 저장 -> yn.equals("y") : true -> !yn.equals("y") : !true
 * 사용자가 "n"을 입력 -> yn에 "n" 저장 -> yn.equals("y") : false -> !yn.equals("y") : !false
 * 
 */ 





