import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LottoNumberScraper {

	public void doScrap() {
		
		try {
			// 지정된 주소로 요청을 보내고 응답 수신 ( 응답은 html )
			Document doc = Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin")
					   			.get();
			
			// System.out.println(doc.body().text());
			System.out.println(doc.title());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		LottoNumberScraper scraper = new LottoNumberScraper();
		scraper.doScrap();
		

	}

}
