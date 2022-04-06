
public class Ex04ControlStatement10 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		///////////////
		
		//1. while 연습
		while(true)	{
			//   50 ~ 150 범위의 난수(정수)를 2개 만들어서 각각 변수에 저장
			int number1 = (int)(Math.random() * 100) + 50;
			int number2 = (int)(Math.random() * 100) + 50;		
			//   합과 평균을 계산해서 변수에 저장
			int sum = number1 + number2;
			int avg = sum / 2;
			//   출력	
			System.out.printf("[%d, %d][TOTAL : %d][AVG : %d]\n", number1, number2,sum, avg);		
			
			//   사용자에게 계속여부를 입력(y/n)받아서 반복하거나 중단 처리
			System.out.print("계속할까요(y/n)? ");
			String yn = scanner.nextLine();
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





