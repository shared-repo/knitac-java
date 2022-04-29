
public class GuAndCountDto {
	
	private String guName;
	private int count;
	
	public GuAndCountDto() {}
	public GuAndCountDto(String guName, int count) {
		this.guName = guName;
		this.count = count;
	}
	
	public String getGuName() {
		return guName;
	}
	public void setGuName(String guName) {
		this.guName = guName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public String toString() {
		return String.format("[자치구 : %s][확진자발생수 : %d]", guName, count);
	}

}
