
class Shape {
	void draw() {
		System.out.println("Shape.draw");
	}
}
class Rectangle extends Shape {
	void draw() {
		System.out.println("Rectangle.draw");
	}
}
class Oval extends Shape {
	void draw() {
		System.out.println("Oval.draw");
	}
}
class Line extends Shape {
	void draw() {
		System.out.println("Line.draw");
	}
}

public class OOP12 {

	public static void main(String[] args) {

		// 1. Oval 5개, Rectangle 5개, Line 5개 사용
		//    Oval, Line, Rectangle 모두를 저장할 수 있는 배열을 만들어서 사용
		Shape[] shapes = new Shape[15]; // Shape 배열은 Rectangle, Line, Oval 모두 저장 가능
		for (int i = 0; i < shapes.length; i++) {
			switch ( i % 3 ) { // 0 or 1 or 2 발생
			case 0: shapes[i] = new Oval(); break;
			case 1: shapes[i] = new Rectangle(); break;
			case 2: shapes[i] = new Line(); break;
			}
		}
		
//		for (int i = 0; i < shapes.length; i++) { 
//			shapes[i].draw(); // 동일한 코드이지만 참조하는 인스턴스에 따라 다른 메서드 호출
//		}
		
		for (Shape s : shapes) { // shapes 배열로부터 순차적으로 하나씩 꺼내서 반복 실행 
			s.draw(); // 동일한 코드이지만 참조하는 인스턴스에 따라 다른 메서드 호출
		}
		
		
	}

}

// 다형성 ( Polymorphism )
// 1. 동일한 코드가 상황에 따라( 참조하는 인스턴스에 따라 ) 다르게 동작하는 현상
// 2. 상속관계의 클래스에서 참조타입과 인스턴스타입이 다르고, 재정의된 메서드 호출이 인스턴스 타입을 따르는 결과











