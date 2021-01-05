package lunch;

import java.time.LocalDate;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Parser {
	public String getMenu(LocalDate day) {
		String menu = null;
		
		String[] days = day.toString().split("-");
		String date = days[0] + days[1] + days[2];
		
		String url = "http://www.y-y.hs.kr/lunch.view?date=" + date;
		
		try {
			Document doc = Jsoup.connect(url).get();
			Element menuDom = doc.selectFirst("#morning .menuName > span");
			
			if(menuDom != null) {
				menu = menuDom.ownText();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("통신 오류 발생");
		}
		
		return menu;
	}
}