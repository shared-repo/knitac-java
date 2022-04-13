
public class Lotto {
	
	java.util.Scanner scanner = new java.util.Scanner(System.in);

	public void doGame() {
		
		while (true) { // 사용자 선택에 따라 반복하는 반복문
			
			// 1. 메뉴 표시 + 사용자 선택
			String selection = selectMenu();			
			System.out.println();
			
			// 2. 사용자 선택에 따라 작업 수행 ( 조건문 사용 )
			if (selection.equals("1")) {
				int[] numbers = selectWinningNumbers();
				int mean = mean(numbers);
				
				// 2-1-3. 뽑힌 번호 출력
				showNumbers(numbers, mean);
						
			} else if (selection.equals("2")) {
				System.out.println("행운을 빕니다. 부자 되세요.");
				break;
			} else {
				System.out.println("지원하지 않는 기능입니다.");
			}			
			System.out.println();			
		}

	}
	
	///////////////////
	void showNumbers(int[] numbers, int mean) {
		System.out.print("SELECTED NUMBERS : ");
		for (int number : numbers) { 
			System.out.printf("[%d]", number);
		}
		System.out.printf("[MEAN : %d]", mean); // 평균 출력
		System.out.println();
	}
	
	String selectMenu() {
		System.out.println("******************************");
		System.out.println("* 1. 당첨 예상 번호 뽑기.");
		System.out.println("* 2. 종료.");
		System.out.println("******************************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		
		return selection;
	}
	
	int mean(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number; // sum = sum + number; 
		}
		int mean = sum / numbers.length;
		
		return mean;
	}
	
	void selectBasicNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {				
			numbers[i] = (int)(Math.random() * 45) + 1;
			// 중복검사를 위한 반복 ( 0부터 현재 뽑힌 위치 i 이전까지 비교 )
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) { // 현재뽑힌번호 == 이전뽑힌번호 / 중복 발생한 경우
				
					// i--; // 현재 위치의 번호 다시 뽑기
					i = -1; // 처음부터 다시 뽑기
					break;
				}
			}
		}
	}
	int[] selectBasicNumbers2() {
		int[] numbers = new int[6];
		for (int i = 0; i < numbers.length; i++) {				
			numbers[i] = (int)(Math.random() * 45) + 1;
			// 중복검사를 위한 반복 ( 0부터 현재 뽑힌 위치 i 이전까지 비교 )
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) { // 현재뽑힌번호 == 이전뽑힌번호 / 중복 발생한 경우
				
					// i--; // 현재 위치의 번호 다시 뽑기
					i = -1; // 처음부터 다시 뽑기
					break;
				}
			}
		}
		return numbers;
	}
	
	int[] selectWinningNumbers() {
		int[] numbers = new int[6];
		int mean = 0;
		do {
			// 2-1-1.기본 번호 뽑기
			// selectBasicNumbers(numbers);
			numbers = selectBasicNumbers2();
			
			// 2-1-2. 평균 계산 + 검사
			mean = mean(numbers);
			
		} while (mean < 20 || mean > 26);
		
		return numbers;
	}
		
	///////////////////////////////////////////////////////
	
	public static void main(String[] args) {

		Lotto lotto = new Lotto();
		lotto.doGame();
		
	}
	
}





