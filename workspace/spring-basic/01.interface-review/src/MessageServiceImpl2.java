import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageServiceImpl2 implements MessageService {

	@Override
	public String makeMessage() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return "Message from Message Service 2 at " + sdf.format(new Date());
	}

}
