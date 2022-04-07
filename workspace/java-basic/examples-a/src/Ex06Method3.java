
public class Ex06Method3 {

	public static void main(String[] args) {
		
		double result = add(10, 20); // 전달인자가 2개인 add 호출
		System.out.println(result);
		
		result = add(10, 20, 30);	// 전달인자가 3개인 add 호출
		System.out.println(result);

	}
	
	static double add(double n1, double n2) {
		double result = n1 + n2;
		
		return result; // 함수 종료 + result를 호출한 곳으로 반환
	}
	
	// 메서드 오버로딩 : 이름이 같지만 전달인자의 자료형, 갯수, 순서 등을 고려해서 다른 함수로 구분하는 기법
	static double add(double n1, double n2, double n3) {
		double result = n1 + n2 + n3;
		
		return result; // 함수 종료 + result를 호출한 곳으로 반환
	}

}
