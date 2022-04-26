import java.util.Scanner;

class CurrencyCalculator {
	private double usd;
	private double eur;
	private double cyn;
	
	public CurrencyCalculator(double usd, double eur, double cyn) {
		super();
		this.usd = usd;
		this.eur = eur;
		this.cyn = cyn;
	}
	
	public double calculate(String targetCurrency, double won) {
		switch (targetCurrency) {
		case "1": return won / usd;
		case "2": return won / eur;
		case "3": return won / cyn;
		default : return 0;
		}
	}
}

public class Ex02ExchangeRate {

	static Scanner scanner = new Scanner(System.in);	
	public static void main(String[] args) {
		CurrencyCalculator calculator = 
				new CurrencyCalculator(1228.50, 1328.75, 192.62);
		while(true) {
			System.out.println("**************************");
			System.out.println("* 1. 환율계산.             *");
			System.out.println("* 2. 종료.                *");
			System.out.println("**************************");
			System.out.print("작업을 선택하세요 : ");
			String selection = scanner.next();
			if (selection.equals("1")) {
				System.out.print("화폐선택(1:USD, 2:EUR, 3:CYN) : ");
				String currency = scanner.next();
				System.out.print("환전금액 (won) : ");
				double won = scanner.nextDouble();
				double result = calculator.calculate(currency, won);
				System.out.printf("환전결과 : %.2f\n", result);
			} else if (selection.equals("2")) {
				System.out.println("프로그램 종료");
				break;
			} else {
				System.out.println("지원하지 않는 명령");
			}
		}

	}

}












