import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LottoNumberScraper {

	public void doScrap() {
		
		try {
			// 지정된 주소로 요청을 보내고 응답 수신 ( 응답은 html )
//			Document doc = Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin")
//					   			.get(); // get 방식 요청
			Document doc = Jsoup.connect("https://dhlottery.co.kr/gameResult.do?method=byWin")
								.data("drwNo", "1004")
								.data("drwNoList", "1004")
								.post(); // post 방식 요청
			
			// System.out.println(doc.body().text());
			System.out.println(doc.title());
			
//			Elements elements = doc.select("#article > div:nth-child(2) > " +
//										   "div > div.win_result > div > " +
//										   "div.num.win > p > span");
			Elements elements = doc.select(".ball_645");
			
			System.out.print("[WINNING NUMBERS] : ");
			for (Element element : elements) {
				System.out.printf("[%2s]", element.text());
			}
			System.out.println();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		LottoNumberScraper scraper = new LottoNumberScraper();
		scraper.doScrap();
		

	}

}
