
public class Ex04ControlStatement7 {

	public static void main(String[] args) {
		
		double d = Math.random(); //0 ~ 1 범위의 double형 난수 발생
		d = d * 10 + 10; // 10 ~ 20 범위의 double형 데이터로 변경
		int n = (int)d; // 10 ~ 20 범위의 int형 데이터로 변경
		
		int x = 0;
		//while (x < 5) {
		while (x < n) {
			System.out.printf("%d번째 데이터\n", (x + 1));
			x += 1; //  x = x + 1;
		}
		
		System.out.println("***************************");
		/////////////////////////////////////////////////////
		
		x = 0;
		while (true) { //무한 반복 ( 반드시 반복문 내부에 실질적인 break 처리가 있어야 합니다. )
			System.out.printf("%d번째 데이터\n", (x + 1));
			x += 1;
			
			if (x >= n) {
				break; //반복문을 종료하는 명령
			}
		}
		
		System.out.println("***************************");
		/////////////////////////////////////////////
		
		x = 0;		
		while (x < n) {
			
			x += 1; //  x = x + 1;
			if (x % 2 == 0) { // 2의 배수 (짝수)
				continue; //반복문의 처음으로 이동
			}
			
			System.out.printf("%d번째 데이터\n", x);
			
		}
		
		System.out.println("***************************");
		///////////////////////////////////////////////////
		x = 0;		
		do {
			System.out.printf("%d번째 데이터\n", (x + 1));
			x += 1; //  x = x + 1;
		} while (x < n);
		
		System.out.println("***************************");
		///////////////////////////////////////////////////
		
		for(x = 0; x < n; x++) {
			System.out.println(x+1);
		}
		
		System.out.println("***************************");
		///////////////////////////////////////////////////
		
		//for(int idx = 0; idx < 10; idx = idx + 1) {
		for(int idx = 0; idx < 10; idx += 2) { // idx += 2 = idx = idx + 2
			System.out.println(idx);
		}
		
	}

}










