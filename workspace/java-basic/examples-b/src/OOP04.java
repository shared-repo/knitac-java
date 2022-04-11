
class ThePoint {
	private double x;
	private double y;
	
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

public class OOP04 {

	public static void main(String[] args) {
		ThePoint point = new ThePoint();
		point.setX(10.12);
		point.setY(23.58);
		
		String loc = point.location();
		System.out.println(loc);

	}

}









