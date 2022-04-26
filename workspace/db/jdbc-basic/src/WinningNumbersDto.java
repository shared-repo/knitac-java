
public class WinningNumbersDto {

	private int round;
	private int no1;
	private int no2;
	private int no3;
	private int no4;
	private int no5;
	private int no6;
	private int bonusNo;
	
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getNo1() {
		return no1;
	}
	public void setNo1(int no1) {
		this.no1 = no1;
	}
	public int getNo2() {
		return no2;
	}
	public void setNo2(int no2) {
		this.no2 = no2;
	}
	public int getNo3() {
		return no3;
	}
	public void setNo3(int no3) {
		this.no3 = no3;
	}
	public int getNo4() {
		return no4;
	}
	public void setNo4(int no4) {
		this.no4 = no4;
	}
	public int getNo5() {
		return no5;
	}
	public void setNo5(int no5) {
		this.no5 = no5;
	}
	public int getNo6() {
		return no6;
	}
	public void setNo6(int no6) {
		this.no6 = no6;
	}
	public int getBonusNo() {
		return bonusNo;
	}
	public void setBonusNo(int bonusNo) {
		this.bonusNo = bonusNo;
	}
	
	@Override
	public String toString() {
		return String.format("[ROUND:%4d][%2d][%2d][%2d][%2d][%2d][%2d][BONUS:%2d]", 
				round, no1, no2, no3, no4, no5, no6, bonusNo);
	}
	
}
