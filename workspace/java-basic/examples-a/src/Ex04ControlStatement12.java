
public class Ex04ControlStatement12 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		// 1-1. 1 ~ 9(포함) 범위의 정수 1개 입력
		System.out.print("출력할 단을 입력하세요 : ");
		int dan = scanner.nextInt();
		
		// 1-2. 입력된 숫자에 해당하는 구구단 출력 (for 사용)
		for (int i = 1; i <= 9; i++) { // i++ / ++i / i += 1 / i = i + 1
			System.out.printf("%d x %d = %d\n", dan, i, dan * i);
		}
		
		System.out.println("============================");
		
		// 2. 전체 구구단 출력 ( 중첩 for문 )
		for (int y = 1; y <= 9; y++) {
			
			for (int x = 1; x <= 9; x++) {
				System.out.printf("%d x %d = %2d  ", x, y, x * y); // %2d : 두칸에 출력
			}
			System.out.println(); // == System.out.printf("\n")
			
		}
		
		
		scanner.close();

	}

}
