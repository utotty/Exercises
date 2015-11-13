package date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
	private static final String DFORMAT = "yyyy-MM-dd HH:mm:ss";
	
	public static String getNowDateStr() {
		Date now = new Date();
		SimpleDateFormat f = new SimpleDateFormat(DFORMAT);
		return f.format(now);
	}
	
	public static String getDateStr(long stamp) {
		Date d = new Date(stamp);
		SimpleDateFormat f = new SimpleDateFormat(DFORMAT);
		return f.format(d);
	}
}
