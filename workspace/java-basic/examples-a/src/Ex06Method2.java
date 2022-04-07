
public class Ex06Method2 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		//1. 사용자 입력 : 박스 그리기에 사용할 문자
		System.out.print("박스 그리기에 사용할 문자 입력 : ");
		String s = scanner.next();
		//2-1. 사용자 입력 : 박스의 너비
		System.out.print("박스의 너비 : ");
		int width = scanner.nextInt();
		//2-2. 사용자 입력 : 박스의 높이
		System.out.print("박스의 높이 : ");
		int height = scanner.nextInt();
		
		drawBox(s, width, height); // 함수 호출 : 함수를 실행하게 만드는 명령
	}
	// 함수 선언 or 정의 : 함수 만들기
	private static void drawBox(String s, int width, int height) {		
		// 상자 출력 ( 20 x 10 )
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (x == 0 || x == width - 1 || 
					y == 0 || y == height - 1) {
					System.out.print(s);
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	
	

}







