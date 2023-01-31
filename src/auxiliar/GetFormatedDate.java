package auxiliar;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetFormatedDate {
	
	public String getDate() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String timeStamp = formatter.format(date);
		return timeStamp;
		
	}

}
