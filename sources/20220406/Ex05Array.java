
public class Ex05Array {

	public static void main(String[] args) {
		
		//1. 배열 만들기
		//int a;
		// int[] ar = null; // 참조 변수 만들기
		// ar = new int[10]; // 요소가 10개인 배열 인스턴스 만들기 + 인스턴스의 주소를 ar 참조변수에 저장
		int[] ar = new int[10]; //int 데이터 10개를 관리하는 배열
		
		//2. 배열 요소 사용
		System.out.printf("%d-%d\n", ar[0], ar[1]);
		
		for (int i = 0; i < 10; i++) { // 1 : 0 ~ 9
			ar[i] = (int)(Math.random() * 900) + 100;
		}
		
		for (int i = 0; i < 10; i++) { // 1 : 0 ~ 9
			System.out.printf("%d번째 데이터 : %d\n", i, ar[i]);
		}
		
		System.out.println("============================");
		
		//3. 배열 초기화
//		int x;  //선언
//		x = 10; //대입
//		int y = 10; // 선언 + 대입 -> 초기화
		
		//int[] ar3 = new int[] { 1, 2, 3, 4, 5 };
		int[] ar3 = { 1, 2, 3, 4, 5 };
		
		for (int i = 0; i < ar3.length; i++) { // 배열.length : 요소 갯수
			System.out.printf("%d번째 데이터 : %d\n", i, ar3[i]);
		}
		
		System.out.println("===============================");
		
		//4. 다차원 배열
		int[][] ar4 = new int[5][7]; // 5행 7열 or 가로(7) x 세로(5)
		for (int row = 0; row < ar4.length; row++) {
			for (int col = 0; col < ar4[row].length; col++) {
				ar4[row][col] = (int)(Math.random() * 900) + 100;
			}
		}
		for (int row = 0; row < ar4.length; row++) {
			for (int col = 0; col < ar4[row].length; col++) {
				System.out.printf("[%5d]", ar4[row][col]);
			}
			System.out.println();
		}
		
		System.out.println("==================================");
		
		//5. 요소의 크기가 다른 2차원 배열
		int[][] ar5 = new int[5][];
		for (int i = 0; i < ar5.length; i++) {
			int[] x = new int[3 + i * 2];
			for (int j = 0; j < x.length; j++) {
				x[j] = (int)(Math.random() * 900) + 100;
			}
			ar5[i] = x;
		}
		
		for (int row = 0; row < ar5.length; row++) {
			for (int col = 0; col < ar5[row].length; col++) {
				System.out.printf("[%5d]", ar5[row][col]);
			}
			System.out.println();
		}
		
		System.out.println("==================================");
		
		// 향상된 for문 사용		
		for (int[] rowItem : ar5) {
			for (int colItem : rowItem) {
				System.out.printf("[%5d]", colItem);
			}
			System.out.println();
		}
		

	}

}








