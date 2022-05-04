import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		try {
			
			while (true) {			
				
				System.out.print("서버로 전송할 메시지 (종료는 enter): ");
				String line = scanner.nextLine();
				System.out.println(line);
				if (line == null || line.length() == 0) {
					break;
				}
				
				// 1. 소켓 만들기 (통신 도구)
				// 2. 연결
				Socket socket = new Socket("192.168.150.6", 8500);
				
				OutputStream os = socket.getOutputStream();
				PrintStream ps = new PrintStream(os); // 한 줄 쓰기 기능이 있는 객체
				
				// 3-1. 네트워크에 데이터 쓰기
				ps.println(line);
				ps.flush(); // 아직 전송되지 않은 데이터가 있다면 강제 전송
			
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);

				// 3-2. 네트워크에서 데이터 읽기
				String message = br.readLine();
				System.out.println(message);
				
				br.close(); isr.close(); is.close();
				ps.close(); os.close();				
				socket.close();
			}
			

			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			
		}

	}

}


