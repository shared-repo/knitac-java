import java.util.Scanner;

// [ 야구게임 ]
// 1. 컴퓨터 번호 선택 (random, 3개, 0 ~ 9, 중복X)
// 2. 사용자 입력 (번호 3개, 0 ~ 9, 중복 X)
// 3. 비교
//    같은위치, 같은번호면 strike
//    다른위치, 같은번호면 ball
//    같은번호가 없으면 out
// 4. 비교 결과 표시
// 5. 비교 결과가 3strike 이면 게임 종료 ( 이겼습니다 표시 ) 아니면 2번부터 다시 반복
// 6. 2 ~ 5의 반복이 10회를 초과하면 게임 종료 ( 졌습니다 표시 )

public class Ex03BaseballGame {

	Scanner scanner = new Scanner(System.in);
	
	public void doGame() {
		
		while (true) {
			
			String selection = selectMenu();
			
			if (selection.equals("1")) {
				
			} else if (selection.equals("2")) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("지원하지 않는 기능입니다.");
			}
		}
		
//		System.out.println("0 ~ 9 범위에서 숫자 세개 입력 (예 : 1 7 6) ");
//		String input = scanner.nextLine(); // nextLine() : 공백을 포함해서 입력 (next() : 공백을 못 읽습니다.)
//		String[] sNumbers = input.split(" "); // split : 주어진 문자를 기준으로 전체 문자열을 분해
//		int[] numbers = new int[3];
//		for (int i = 0; i < sNumbers.length; i++) {
//			System.out.println(sNumbers[i]);
//			numbers[i] = Integer.parseInt(sNumbers[i]); // Integer.parseInt : 문자열 -> 숫자
//		}
		
		

	}

	private String selectMenu() {
		System.out.println("*********************");
		System.out.println("* 1. 게임시작         *");
		System.out.println("* 2. 종료            *");
		System.out.println("*********************");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		return selection;
	}

}
