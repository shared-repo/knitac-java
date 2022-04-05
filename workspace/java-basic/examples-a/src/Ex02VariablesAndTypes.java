
public class Ex02VariablesAndTypes {

	public static void main(String[] args) {
		
		//1. 변수 만들기 ( 이름, 자료형 )
		int age; // int : 정수, 4byte
		String name; // String : 문자열형
		
		//2. 변수 사용 : 변수에 데이터 저장
		age = 35;
		name = "John Doe";
		
		//3. 변수 사용 : 변수의 데이터 읽기
		System.out.println("Name : " + name + " / Age : " + age);
		
		//4. 변수 사용 : 연산
		age = age + 1;
		System.out.println("Name : " + name + " / Age : " + age);
		
		//5. 변수 초기화 : 변수 선언 + 값 저장
		int height = 180;
		System.out.println("Height : " + height);
		
		//////////////////////////////////////////////////
		
		//정수형 변수 x를 만들고 100을 저장한 후 
		//x변수에 저장된 값에 50을 곱해서 x2에 저장하고
		//결과를 출력하세요
		
		//6. boolean(논리형) 자료형 사용 
		//   (참-true, 거짓-false 두 개의 데이터만 사용하는 자료형)
		boolean b = true;
		System.out.println(b); //true 출력
		b = false;
		System.out.println(b); //false 출력
		// b = 10;//오류 : 다른 데이터 저장 불가능
		
		//7. 문자/문자열 자료형 사용
		//   ( 문자 : 'A', 문자열 : "ABC" )
		char c = 'A'; //문자 ( 1개의 문자 )
		System.out.println(c); // A 출력
		System.out.println( (int)c ); // 65 출력, (자료형)변수 -> 변수를 지정된 자료형을 사용 
		
		String s = "ABC"; //문자열 ( 0개 이상의 문자 집합 )
		System.out.println(s);
		
		//8. 기본값(초기값)
		
		int x;	// 이 때 x에는 어떤 값이 저장되어 있을까요? -> 가비지
		// System.out.println(x); //오류 - 값을 저장하지 않은 변수 사용 X
		x = 10;
		System.out.println(x);
	
		
		//6. overflow, underflow
		int max = 2147483647;//int 자료형으로 표현할 수 있는 최대값
		System.out.println(max);
		max = max + 1; //표현범위를 넘어서는 데이터 처리?
		System.out.println(max);
		
		//7. 형변환 ( 데이터를 원래 자료형과 다른 자료형으로 사용 )
		int x2 = 10;
		double d2 = x2; // 암시적(묵시적) 형변환 int -> double
		double d3 = 11.11;
		int x3 = (int)d3; // 명시적 형변환 double -> int
		System.out.println(d2);
		System.out.println(x3);
		System.out.println(d3); //형변환 이후 원래 변수의 자료형?
		
		
	}

}














