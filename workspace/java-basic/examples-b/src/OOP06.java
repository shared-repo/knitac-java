
class ThePoint2 {
	private double x;
	private double y;
	
	// 2개의 생성자 메서드 만들기 : 
	// - 전달인자 없는 생성자
	public ThePoint2() {
		System.out.println("constructor with no arg");
	}
	// - x, y를 전달인자로 하는 생성자 : 전달인자를 사용해서 x, y의 값 저장
	public ThePoint2(double x, double y) {
		System.out.println("constructor with 2 args");
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}

	String location() {
		String loc = String.format("[%.2f][%.2f]", x, y); // .2f : 소수점 이하 2자리까지 사용
		return loc;
	}
}

public class OOP06 {

	public static void main(String[] args) {
		
		//생성자 메서드를 사용하는 instance 생성 구문 작성
		ThePoint2 p1 = new ThePoint2(); // 전달인자 없는 생성자 메서드 호출
		
		ThePoint2 p2 = new ThePoint2(56.28, 65.99);
		System.out.println(p2.location());
	}

}









