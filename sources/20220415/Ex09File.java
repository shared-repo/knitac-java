import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09File {

	public static void main(String[] args) {
		
		//C:\Windows 디렉터리를 관리하는 객체 만들기
		File winDir = new File("C:\\Windows") ;
		
		//if (winDir.isDirectory() == false) { //isDirectory() : 디렉터리라면 true 반환
		if ( !winDir.isDirectory() ) { //! : 논리부정연산자 -> !true == false / !false == true
			System.out.println("정상적인 디렉터리(폴더)가 아닙니다.");
			return;
		}
		
		//winDir 객체가 관리하는 디렉터리에 포함된 모든 파일 및 디렉터리를 파일 객체에 담아서 배열로 반환 
		File[] filesOrDirs = winDir.listFiles();
		for (File fileOrDir : filesOrDirs) { // 순회 : 목록의 처음부터 끝까지 한 번씩 순차적으로 사용
			//System.out.println(fileOrDir.getAbsolutePath()); // getAbsolutePath : 전체 경로 반환
			
			//시간을 "2019-10-28 오후 04:27" 형식의 문자열로 변환하는 객체 만들기
			SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd a hh:mm");
			//java.util.Date : 날짜와 시간을 관리하는 클래스 / 여기서는 경과시간으로 객체 생성
			Date lastModified = new Date(fileOrDir.lastModified());
			
			if (fileOrDir.isDirectory()) { // 디렉터리인 경우
				System.out.printf("%s%7s%12s %s\n", 
								  f.format(lastModified), //마지막 수정 일자, 날짜 -> 문자열로 변환
								  "<DIR>",
								  "",
								  fileOrDir.getName()); // 파일의 이름
			} else { // 파일인 경우
				System.out.printf("%s%7s%,12d %s\n", 
						  		  f.format(lastModified), //마지막 수정 일자, 날짜 -> 문자열로 변환
						  		  "",
						  		  fileOrDir.length(), // 파일의 크기 (in byte)
						  		  fileOrDir.getName()); // 파일의 이름  
			}
		}
		
		
		
		
		

	}

}











