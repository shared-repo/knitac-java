
public class Ex03ControlStatement1 {
	
	public static void main(String[] args) {
		
		// 1. 난수 발생		
		double rn = Math.random(); // Math.random() : 0 ~ 1 범위에서 무작위 값 추출
		// System.out.println(rn);
		
		// 2. 난수를 0 ~ 100 범위의 정수로 변환
		int number = (int)(rn * 100); // 0 ~ 100 범위에서 뽑힌 무작위 정수
		// System.out.println(number);
		
		// 3-1. 80보다 크면 "80보다 큽니다" 출력
		if (number > 80) {
			System.out.println("80보다 큽니다.");
		}
		System.out.println("1 ============================");
		// 3-2. 80보다 크면 "80보다 큽니다" 출력 아니면 "80보다 작습니다" 출력
		if (number > 80) {
			System.out.println("80보다 큽니다.");
		} else {
			System.out.println("80보다 작습니다.");
		}
		System.out.println("2 ============================");
		// 3-3. 80보다 크면 "80보다 큽니다" 출력 80보다 작으면 "80보다 작습니다" 아니면 80입니다 출력
		if (number > 80) {
			System.out.println("80보다 큽니다.");
		} else if (number < 80) {
			System.out.println("80보다 작습니다.");
		} else { // 위 조건에 해당되지 않는 나머지 모든 경우
			System.out.println("80입니다.");
		}
		System.out.println("3 ============================");
		if (number > 80) {
			System.out.println("80보다 큽니다.");
		} else if (number == 80) {
			System.out.println("80입니다.");
		} else { // 위 조건에 해당되지 않는 나머지 모든 경우
			System.out.println("80보다 작습니다.");
		}
		
		//3-4. 위의 난수를 사용해서 다음과 같이 출력하세요.
		//     0 ~ 20 : A, 
		//     20 ~ 40 : B, 
		//     40 ~ 60 : C, 
		//     60 ~ 80 : D, 
		//     80 ~ 100 : E
		System.out.println("Random Number : " + number);
		if (number < 20) {
			System.out.println("A");
		} else if (number < 40) {
			System.out.println("B");
		} else if (number < 60) {
			System.out.println("C");
		} else if (number < 80) {
		 	System.out.println("D");
		} else {
			System.out.println("E");
		}
		

	}

}











