import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageServiceImpl implements MessageService {

	@Override
	public String makeMessage() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return "Message from Message Service at " + sdf.format(new Date());
	}

}
