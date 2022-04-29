
public class SeoulCoronaStatsDto {
	
	private int idx;
	private String regDate;
	private String guName;
	private int total;
	private int today;
		
	public SeoulCoronaStatsDto() {}
	public SeoulCoronaStatsDto(int idx, String regDate, String guName, int total, int today) {
		this.idx = idx;
		this.regDate = regDate;
		this.guName = guName;
		this.total = total;
		this.today = today;
	}
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getGuName() {
		return guName;
	}
	public void setGuName(String guName) {
		this.guName = guName;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}

	@Override
	public String toString() {
		return String.format("[%6d][%s][%10s][%7d][%6d]", 
							 idx, regDate, guName, total, today);		
	}
	
}
