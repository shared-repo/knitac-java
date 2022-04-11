
class MyClass {
	int data1;			// 인스턴스형 : new 할 때 새로 만들어지는 변수
	int data2;
	
	static int data3;	// 클래스형 : 1번만 만들어져서 모든 인스턴스가 공유하는 변수
	
	static void staticMethod() {
		System.out.println("this is static method");
		// data2 = 10; // static 메서드 안에서 인스턴스형 멤버 사용할 수 없습니다.
		data3 = 100;
	}
}

public class OOP07 {

	public static void main(String[] args) {
		
		MyClass obj1 = new MyClass();
		obj1.data1 = 100;
		obj1.data2 = 200;
		obj1.data3 = 500;
		
		MyClass obj2 = new MyClass();
		obj2.data1 = 800;
		obj2.data2 = 900;
		obj2.data3 = 600;
		
		System.out.println("obj1.data1 = " + obj1.data1);
		System.out.println("obj2.data1 = " + obj2.data1);
		System.out.println("obj1.data3 = " + obj1.data3);
		System.out.println("obj2.data3 = " + obj2.data3);
		
		// static형 멤버는 클래스이름으로 접근
		System.out.println("MyClass.data3 = " + MyClass.data3);		
		MyClass.staticMethod();
		
		

	}

}
