import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		
		ServerSocket listener = null;
		
		try {
			// 1. 소켓 만들기 (교환수 역할)
			// 2. ip, port 할당 ( ip는 현재 컴퓨터의 모든 IP 사용 )
			// 3. backlog 설정 ( 최대 대기 연결 수 )
			listener = new ServerSocket(8500, 10);
			
			System.out.println("***** 서버가 시작되었습니다 *****");
			
			while (true) {
				// 4. 수신 대기
				//    클라이언트의 연결 기다리기 -> 클라이언트가 연결하면 새로운 소켓으로 연결해서 반환
				Socket socket = listener.accept();
				
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				// 5-1. 네트워크에서 데이터 읽기
				String message = br.readLine();
				System.out.printf("[%s]: %s\n", 
								  socket.getRemoteSocketAddress().toString(), // 연결된 컴퓨터
								  message);
				
				OutputStream os = socket.getOutputStream();
				PrintStream ps = new PrintStream(os); // 한 줄 쓰기 기능이 있는 객체
				// 5-2. 네트워크에 데이터 쓰기
				ps.println("message from server : " + message);
				ps.flush(); // 아직 전송되지 않은 데이터가 있다면 강제 전송
				
				ps.close(); os.close();
				br.close(); isr.close(); is.close();
				socket.close();
			
			}
			
		} catch (Exception ex) {
			
		} finally {
			try { listener.close(); } catch (Exception ex) {}
		}

	}

}


