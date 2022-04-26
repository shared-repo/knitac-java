import java.io.Serializable;

// 파일에 기록하고, 파일로 부터 읽는 클래스타입은 
// 반드시 Serializable 인터페이스를 구현해야 합니다.
public class Item implements Serializable {	
	private int no;
	private String name;	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	@Override
	public String toString() {
		return String.format("[%d][%s]", no, name);
	}
}
