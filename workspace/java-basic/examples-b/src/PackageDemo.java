import java.util.Scanner;

import com.example.a.TheClass; // 지금부터 TheClass는 com.example.a.TheClass입니다.

public class PackageDemo {

	public static void main(String[] args) {
		
		// 1. 클래스를 사용하려면 패키지이름.클래스이름으로 사용해야 합니다.
		com.example.a.TheClass obj = new com.example.a.TheClass();
		
		// 2. import를 사용해서 미리 등록한 클래스는 패키지이름 생략 가능
		TheClass obj2 = new TheClass();
		
		// 3. 응용
		// java.util.Scanner scanner = new java.util.Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		
		// 4. 다른 패키지의 public이 아닌 클래스는 사용할 수 없습니다.
		//com.example.b.TheClass c = new com.example.b.TheClass();

	}

}
