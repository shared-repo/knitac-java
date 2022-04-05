
public class Ex04ControlStatement4 {

	public static void main(String[] args) {
		
		//1. 점수 3개 입력 (정수)
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		System.out.print("점수 1 : ");
		int score1 = scanner.nextInt();
		System.out.print("점수 2 : ");
		int score2 = scanner.nextInt();
		System.out.print("점수 3 : ");
		int score3 = scanner.nextInt();		
		
		//2. 입력된 점수의 합과 평균 계산해서 변수에 저장 (합 : 정수, 평균 : 실수)
		int total = score1 + score2 + score3;
		double mean = total / 3;
		
		//3. 등급을 계산해서 변수에 저장 (평균 기준)
		//   90 ~ 100 : A, 80 ~ 89 : B, 
		//   70 ~ 79 : C, 60 ~ 69 : D, 나머지 : F
		char grade = 'F';
		boolean valid = true;
		//if (90 <= mean <= 100) { //오류 (90 <= mean) <= 100
		//if (90 <= mean mean <= 100) { //오류 : true false
		if (90 <= mean && mean <= 100) {
			grade = 'A';
		} else if (80 <= mean && mean < 90) {
			grade = 'B';
		} else if (70 <= mean && mean < 80) {
			grade = 'C';
		} else if (60 <= mean && mean < 70) {
			grade = 'D';
		} else if (0 <= mean && mean < 60) {
			grade = 'F';
		} else {
			valid = false;
		}		
		if (valid == true) {
			//4. 출력 : 형식 -> [총점 : 100][평균 : 40점][등급 : A]
			System.out.printf("[총점 : %d][평균 : %.2f][등급 : %c]", 
							  total, mean, grade);
		} else {
			System.out.println("입력에 오류가 있습니다.");
		}
	}

}










