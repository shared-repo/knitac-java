import java.util.Scanner;

public class Ex03BaseballGame {

	static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("0 ~ 9 범위에서 숫자 세개 입력 (예 : 1 7 6) ");
		String input = scanner.nextLine(); // nextLine() : 공백을 포함해서 입력 (next() : 공백을 못 읽습니다.)
		String[] sNumbers = input.split(" "); // split : 주어진 문자를 기준으로 전체 문자열을 분해
		int[] numbers = new int[3];
		for (int i = 0; i < sNumbers.length; i++) {
			System.out.println(sNumbers[i]);
			numbers[i] = Integer.parseInt(sNumbers[i]); // Integer.parseInt : 문자열 -> 숫자
		}
		
		

	}

}
