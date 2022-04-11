
//           int
public class Person {
	
	// 1. 특성 ( Data, 변수 --> 필드 )
	String name;
	String phone;
	String email;
	
	// 2. 기능 ( Method )
	String info() {		
		// return "[" + name + "][" + phone + "][" + email + "]";		
		String s = "[" + name + "][" + phone + "][" + email + "]";
		return s;
	}

}
