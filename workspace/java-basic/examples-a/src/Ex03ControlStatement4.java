
public class Ex03ControlStatement4 {

	public static void main(String[] args) {
		
		// 중복 여부 찾기
		
		//1. 1 ~ 10 범위에서 난수 3개 발생 -> 각각 변수에 저장
		int number1 = (int)(Math.random() * 10) + 1;
		int number2 = (int)(Math.random() * 10) + 1;
		int number3 = (int)(Math.random() * 10) + 1;
		
		//2. 중복이 있으면 "중복", 없으면 "유효"를 출력
		
		// System.out.println(number1 + " / " + number2 + " / " + number3);
		System.out.printf("[%d][%d][%d]\n", number1, number2, number3);
		
		if (number1 == number2 || number2 == number3 || number3 == number1) {
			System.out.println("중복");
		} else {
			System.out.println("유효");
		}
		
		if ( (number1 != number2) && 
			 (number2 != number3) && 
			 (number3 != number1) ) {
			System.out.println("유효");
		} else {
			System.out.println("중복");
		}

	}

}

/*
 * System.out.printf("서식 + 문자열", data1, data2, .... )
 * [ 서식의 종류 (자료형 기준) ]
 * - %d : 정수형 데이터 서식
 * - %f : 실수형 데이터 서식
 * - %s : 문자열 데이터 서식
 * - %c : 문자형 데이터 서식
 * - %b : 논리형 데이터 서식
 * 
 * Escape Sequence : 명시적으로 표현하기 어려운 문자를 문자열에서 표현하는 방법
 * - \n : enter
 * - \t : tab
 * - \b : backspace
 * - \r : home
 * - \" : "
 * - \' : '
 * - \\ : \
 * 
 * 
 * 
 * 
 * 
 */ 
