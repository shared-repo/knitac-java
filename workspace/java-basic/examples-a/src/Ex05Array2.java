
public class Ex05Array2 {

	public static void main(String[] args) {
		
		// 로또 당첨 예상 번호 뽑기
		// 1. 기본 규칙을 적용한 번호 뽑기 -> 배열에 저장, for 사용
		//    1 ~ 45, random, 중복X, 6개 
		
		// 2. 평균 검사
		//    평균이 20 ~ 26이 아니면 1부터 다시
		
		// 3. 배열에 저장된 뽑힌 숫자 출력 -> for 사용
		
		// 4. 사용자 선택에 따라 반복
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		while (true) { // 사용자 선택에 따라 반복하는 반복문
			
			System.out.println("******************************");
			System.out.println("* 1. 당첨 예상 번호 뽑기.");
			System.out.println("* 2. 종료.");
			System.out.println("******************************");
			System.out.print("작업을 선택하세요 : ");
			String selection = scanner.nextLine();
			
			if (selection.equals("1")) {
				int[] numbers = new int[6];
				// 기본 번호 뽑기
				for (int i = 0; i < numbers.length; i++) {
					numbers[i] = (int)(Math.random() * 45) + 1;
				}
				
				// 뽑힌 번호 출력
				System.out.print("SELECTED NUMBERS : ");
				for (int number : numbers) {
					System.out.printf("[%d]", number);
				}
				System.out.println();
						
			} else if (selection.equals("2")) {
				System.out.println("행운을 빕니다. 부자 되세요.");
				break;
			} else {
				System.out.println("지원하지 않는 기능입니다.");
			}
			
		}

	}

}





