
public class Ex06Method1 {

	public static void main(String[] args) {
		
		// 중괄호는 영역을 만듭니다.
		{
			int a = 10;
			a = 20;
			{
				a = 30; // 변수가 선언된 영역의 하위 영역에서는 사용 가능
				int b = 40;
			}
			{
				// b = 50; // 선언된 영역 외수에서 변수 사용 X
			}
		}
		// a = 30; 선언된 영역 외부에서 변수 사용 X 
		
		drawBox(); // 함수 호출 : 함수를 실행하게 만드는 명령		

	}

	// 함수 선언 or 정의 : 함수 만들기
	private static void drawBox() {
		// 상자 출력 ( 20 x 10 )
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 20; x++) {
				if (x == 0 || x == 20 - 1 || 
					y == 0 || y == 10 - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	
	

}







