
public class Ex03ControlStatement3 {

	public static void main(String[] args) {
		
		// 1. 최대값 찾기
		// 1-1. 1 ~ 100 사이의 난수 3개를 뽑아서 각각 변수에 저장
		int number1 = (int)(Math.random() * 100) + 1;
		int number2 = (int)(Math.random() * 100) + 1;
		int number3 = (int)(Math.random() * 100) + 1;
		
		int max;
		// 1-2-1. 위에서 뽑힌 3개의 숫자 중 가장 큰 숫자를 찾아서 변수에 저장		
		max = number1;
		if (number2 > max) {
			max = number2;
		}
		if (number3 > max) {
			max = number3;
		}
		
		// 1-2-2. 위에서 뽑힌 3개의 숫자 중 가장 큰 숫자를 찾아서 변수에 저장
//		if (number1 > number2 && number1 > number3) {
//			max = number1;
//		} else if (number2 > number3 && number2 > number1) {
//			max = number2;
//		} else {
//			max = number3;
//		}
		
		// 1-3. 가장 큰 숫자 출력
		System.out.println(number1 + " / " + number2 + " / " + number3);
		System.out.println("Max Value : " + max);

	}

}







