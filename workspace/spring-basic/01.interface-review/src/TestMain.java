import java.lang.reflect.Method;

public class TestMain {

	public static void main(String[] args) {

		ServiceConsumerImpl sc = new ServiceConsumerImpl();
		
		sc.doSomething();
		
		///////////////////////////////////////
		
		try {
			// "java.lang.String" -> String 클래스 정보
//			Class claz = Class.forName("java.lang.String"); // String
//			String s = (String)claz.newInstance(); // new String();
//			
//			System.out.println(s.getClass().toString());
			
			//클래스의 모든 메서드를 배열로 가져오기.
//			Method[] methods = claz.getMethods();
//			for (Method method : methods) {
//				System.out.println(method.getName());
//				
//				if (method.getName().equals("length")) {					
//					//invoke() : 지정된 메서드를 실행하는 명령
//					int length = (int)method.invoke(s); //s.length()
//					System.out.println(length);
//				}
//			}			

			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

}
