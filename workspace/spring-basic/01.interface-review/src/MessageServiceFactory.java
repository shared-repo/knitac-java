import java.io.FileInputStream;
import java.util.Properties;

public class MessageServiceFactory {
	
//	public MessageService getInstance(String type) {
//		
//		switch (type) {
//			case "1": return new MessageServiceImpl();
//			case "2": return new MessageServiceImpl2();
//			default: return null;
//		}
//	}
	
	public MessageService getInstance(String type) {
		
		try {
			//xxx.properties파일의 데이터를 읽어서 
			//key-value 형식으로 관리하는 컬렉션 객체
			Properties props = new Properties();
			
			FileInputStream fis = new FileInputStream("mappings.properties");
			props.load(fis); // 이 때 파일의 데이터를 읽어서 컬렉션 구성
			
			String typeName = props.getProperty(type);// 문자열 타입 이름 찾기
			
			Class claz = Class.forName(typeName); //문자열 타입 이름 클래스 객체 만들기
			// new를 이용한 객체 생성 구문과 동일한 기능
			MessageService messageService = (MessageService)claz.newInstance(); 
			
			return messageService;
			
		} catch (Exception ex) {
			return null;
		}	
		
	}

}












