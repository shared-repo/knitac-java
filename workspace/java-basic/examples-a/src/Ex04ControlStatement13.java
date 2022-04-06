
public class Ex04ControlStatement13 {

	public static void main(String[] args) {
		
		// 1. 상자 출력 ( 20 x 10 )
		for (int y = 0; y < 10; y++) {
			for (int x = 0; x < 20; x++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		
		// 2. 상자 출력 ( 20 x 10 )
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
