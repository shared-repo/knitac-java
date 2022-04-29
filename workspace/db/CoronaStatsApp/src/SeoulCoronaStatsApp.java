import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeoulCoronaStatsApp {
	
	private Scanner scanner = new Scanner(System.in);
	
	public void doStart() {
		
		while (true) {
			String selection = selectMenu();
			System.out.println();
			
			if (selection.equals("0")) {
				System.out.println(">>>>> 프로그램이 종료됩니다. <<<<<");
				break;
			} else if (selection.equals("1")) {
				// 1. 파일에서 데이터 읽기 ( 현재 클래스에 메서드 생성 )
				List<SeoulCoronaStatsDto> stats = readFromFile();
				for (SeoulCoronaStatsDto dto : stats) {
					System.out.println(dto);
				}
				// 2. 데이터베이스에 데이터 저장 ( Dao 클래스에 메서드 생성 )
			} else if (selection.equals("2")) {
			
			} else if (selection.equals("3")) {
				
			} else if (selection.equals("4")) {
				
			} else if (selection.equals("5")) {
				
			} else if (selection.equals("6")) {
				
			}  else {
				System.out.println(">>>>> 지원하지 않는 작업입니다. <<<<<");
			}
			
			System.out.println();
		}
		
	}
	
	public List<SeoulCoronaStatsDto> readFromFile() {
		
		FileInputStream fis = null;		// disk에서 byte[] 형식으로 데이터 읽기
		InputStreamReader isr = null;	// byte[] -> char[] 변환
		BufferedReader br = null;		// char[] -> [ "...\n", "...\n", ... ]
		ArrayList<SeoulCoronaStatsDto> stats = new ArrayList<>();
		try {
			fis = new FileInputStream("seoul-corona-stats.csv");
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			while (true) {
				String line = br.readLine(); 	// "a,b,c,d"
				String[] row = line.split(","); // "a,b,c,d" -> ["a", "b", "c", "d"]
				
				SeoulCoronaStatsDto dto = 
						new SeoulCoronaStatsDto(0, row[0], row[1], 
												Integer.parseInt(row[2]),
												Integer.parseInt(row[3]));
//				SeoulCoronaStatsDto dto = new SeoulCoronaStatsDto();
//				dto.setRegDate(row[0]);
//				dto.setGuName(row[1]);
//				dto.setTotal(Integer.parseInt(row[2]));
//				dto.setToday(Integer.parseInt(row[3]));
				stats.add(dto);
			}
		} catch (Exception ex) {
			ex.printStackTrace(); // 오류 메시지 화면에 출력
		} finally {
			try { br.close(); } catch (Exception ex) {}
			try { isr.close(); } catch (Exception ex) {}
			try { fis.close(); } catch (Exception ex) {}
		}
		
		return stats;
	}
	
	public String selectMenu() {
		System.out.println("************************************");
		System.out.println("* 1. 데이터 저장");
		System.out.println("* 2. 데이터 초기화");
		System.out.println("* 3. 일자별 확진자 발생 현황 조회");
		System.out.println("* 4. 자치구별 확진자 발생 현황 조회");
		System.out.println("* 5. 일자별, 자치구별 확진자 발생 현황 조회");
		System.out.println("* 6. 최대 확진자 발생일자와 자치구 조회");
		System.out.println("* 0. 종료");
		System.out.println("************************************");
		System.out.print("작업 번호 : ");
		String selection = scanner.nextLine();
		return selection;
		
	}
	

	public static void main(String[] args) {
		
		SeoulCoronaStatsApp app = new SeoulCoronaStatsApp();
		app.doStart();
	}

}
