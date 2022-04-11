
// [ 영화 정보를 저장하는 클래스 만들기 ]
// 필드 : 제목(문자열), 감독(문자열), 주연(문자열), 개봉년도(숫자, 정수), 평점(숫자, 실수)
// 메서드 : 필드를 문자열로 만들어서 반환
// 필드는 모두 private -> getter, setter 만들기
// 생성자 메서드 만들기
class Movie {
	private String title;
	private String director;
	private String mainActor;
	private int year;
	private double score;
	
	public Movie() {		
	}
	public Movie(String title, String director, String mainActor, int year, double score) {
		this.title = title;
		this.director = director;
		this.mainActor = mainActor;
		this.year = year;
		this.score = score;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getMainActor() {
		return mainActor;
	}
	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}

	public String info() {
		return String.format("[%s][%s][%s][%d][%.2f]", 
							 title, director, mainActor, year, score);
	}
}


public class OOP08 {

	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in); 
		
		// 사용 코드 작성
		// - 데이터 입력
		System.out.print("영화 제목 : ");
		String title = scanner.nextLine(); // 공백을 포함해서 입력 ( next() : 공백 단위로 구분 )
		System.out.print("감독 : ");
		String director = scanner.nextLine();
		System.out.print("주연 배우 : ");
		String mainActor = scanner.nextLine();
		System.out.print("개봉 년도 : ");
		int year = scanner.nextInt();		
		
		// - 인스턴스 만들기 ( 값 초기화 )
		Movie movie = new Movie(title, director, mainActor, year, 0);		
		
		// - 출력
		System.out.println(movie.info());
		
		scanner.close();

	}

}
