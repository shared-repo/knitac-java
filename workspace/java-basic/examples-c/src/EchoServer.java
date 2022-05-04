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
			
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			OutputStream os = null;
			PrintStream ps = null;
			Socket socket = null;
			
			while (true) {
				try {
					// 4. 수신 대기
					//    클라이언트의 연결 기다리기 -> 클라이언트가 연결하면 새로운 소켓으로 연결해서 반환
					socket = listener.accept();
					
					is = socket.getInputStream();
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					
					// 5-1. 네트워크에서 데이터 읽기
					String message = br.readLine();
					System.out.printf("[%s]: %s\n", 
									  socket.getRemoteSocketAddress().toString(), // 연결된 컴퓨터
									  message);
					
					os = socket.getOutputStream();
					ps = new PrintStream(os); // 한 줄 쓰기 기능이 있는 객체
					// 5-2. 네트워크에 데이터 쓰기
					ps.println("message from server : " + message);
					ps.flush(); // 아직 전송되지 않은 데이터가 있다면 강제 전송
					
				} catch (Exception ex) {
					System.out.println("1");					
				} finally {
					try {ps.close();} catch (Exception ex) {}
					try {os.close();} catch (Exception ex) {}
					try {br.close();} catch (Exception ex) {}
					try {isr.close();} catch (Exception ex) {}
					try {is.close();} catch (Exception ex) {}
					try {socket.close();} catch (Exception ex) {}

				}
			
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { listener.close(); } catch (Exception ex) {}
		}

	}

}


